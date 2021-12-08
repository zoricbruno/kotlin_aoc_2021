package day08.displays

class SegmentParser {

    private val ioSeparator: String = " | "
    private val signalSeparator: Char = ' '

    fun parse(input: List<String>): List<Display>{
        return input.map { parse(it) }
    }

    fun parse(input: String): Display {
        val parts = input.split(ioSeparator)
        val digitSignals = parseDigits(parts[0])
        val outputDigits = parseDigits(parts[1])
        return Display(digitSignals, outputDigits)
    }

    private fun parseDigits(input: String): List<String> {
        return input.split(signalSeparator).toList()
    }
}

