package day11.dumbo

class OctopusParser {
    fun parse(input: List<String>): List<List<Octopus>> {
        return input.map { parse(it) }
    }

    fun parse(input: String): List<Octopus> {
        return input.map { Octopus(it.toString().toInt(), 0) }
    }
}