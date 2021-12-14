package day12.mapping.path

class PathParser {

    val nodeSeparator = '-'

    fun parse(input: List<String>): List<Path>{
        return input.map { parse(it) }
    }

    fun parse(input: String): Path {
        val parts = input.split(nodeSeparator)
        return Path(parts[0], parts[1])
    }
}