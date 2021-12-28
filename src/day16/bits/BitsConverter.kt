package day16.bits

import kotlin.math.pow

object BitsConverter {

    private val mapToBinary = mapOf<Char, String>(
        '0' to "0000",
        '1' to "0001",
        '2' to "0010",
        '3' to "0011",
        '4' to "0100",
        '5' to "0101",
        '6' to "0110",
        '7' to "0111",
        '8' to "1000",
        '9' to "1001",
        'A' to "1010",
        'B' to "1011",
        'C' to "1100",
        'D' to "1101",
        'E' to "1110",
        'F' to "1111",
    )

    fun toBinary(hex: String): String {
        return hex.map {
            mapToBinary.getOrDefault(it, "")}
            .joinToString("")
    }

    fun toInteger(binaryInput: String): Int{
        var total = 0
        for((index, value) in binaryInput.reversed().withIndex()){
            total += value.digitToInt()  * 2.0.pow(index).toInt()
        }
        return total
    }
}