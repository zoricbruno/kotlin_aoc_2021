package day09.lava

class HeightMapParser {
    fun parse(input: List<String>): HeightMap {
        return HeightMap(input.map { parse(it) })
    }

    fun parse(input: String): List<Int> {
        return input.map { it.toString() }.map { it.toInt() }
    }
}

