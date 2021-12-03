package day03.diagnostics

import kotlin.math.pow

class BinaryConverter {

    fun fromBitStringToInt(binary: String): Int {
        var value = 0
        for ((pow, bit) in binary.reversed().withIndex()) {
            value += (if (bit == '1') 1 else 0) * 2.0.pow(pow).toInt()
        }
        return value
    }

    fun invert(binary: Char): Char = if (binary == '1') '0' else '1'

    fun invert(binary: String): String = binary.map { invert(it) }.joinToString(separator = "")

    fun findMostCommonBit(codes: List<String>, column: Int): Char {
        val map = { bitString: String -> if (bitString[column] == '1') 1 else 0 }
        val count: Int = codes.sumOf { map(it) }
        return if (count >= codes.size / 2.0) '1' else '0'
    }

    fun findLeastCommonBit(codes: List<String>, column: Int): Char =
        invert(findMostCommonBit(codes, column))

    fun findMostCommonBits(bitStrings: List<String>): String {
        val mostCommon = mutableListOf<Char>()
        for (position in 0 until bitStrings.first().length) {
            mostCommon.add(findMostCommonBit(bitStrings, position))
        }
        return mostCommon.joinToString(separator = "")
    }

    fun findLeastCommonBits(bitStrings: List<String>): String = invert(findMostCommonBits(bitStrings))

    fun filter(codes: List<String>, mask: (List<String>, Int) -> Char): String {
        var filtered = codes.toList()
        val bitStringSize = filtered.first().length
        var currentBitIndex = 0
        while (filtered.size > 1 && currentBitIndex < bitStringSize) {
            val bit = mask(filtered, currentBitIndex)
            filtered = filtered.filter { it[currentBitIndex] == bit }
            currentBitIndex++
        }
        return filtered.first()
    }
}