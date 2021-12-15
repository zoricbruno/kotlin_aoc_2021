package day14.polymerization

class PolymerizatorParser {

    private val polymerDelimiter = " -> "

    fun parsePolymer(input: List<String>): String {
        return input.first()
    }

    fun parsePolymerizer(input: List<String>): Polymerizer {
        val map = mutableMapOf<String, Char>()
        input.drop(2)
            .map { it.split(polymerDelimiter) }
            .forEach { map[it.first()] = it.last()[0] }
        return Polymerizer(map)
    }
}

