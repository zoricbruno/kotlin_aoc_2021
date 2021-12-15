package day14.polymerization

class Polymerizer(
    private val mapper: Map<String, Char>
) {
    fun findDifferenceBetweenMaxAndMin(polymer: String, steps: Int): Long{
        var polymerized = polymerize(polymer, steps)
        val charsMap = mutableMapOf<Char, Long>()

        polymerized.forEach{
            charsMap[it] = charsMap.getOrDefault(it, 0) + 1
        }
        return charsMap.maxOf { it.value } - charsMap.minOf { it.value }
    }

    fun polymerize(polymer: String, steps: Int): String {
        var polymerized = polymer
        repeat(steps){
            polymerized = polymerize(polymerized)
        }
        return polymerized
    }

    private fun polymerize(polymer: String): String {
        val chars = mutableListOf<Char>()
        for (i in 0 until polymer.count() - 1) {
            chars.add(polymer[i])
            chars.add(map(polymer[i], polymer[i + 1]))
        }
        chars.add(polymer[polymer.count() - 1])
        return chars.joinToString("")
    }

    private fun map(a: Char, b: Char): Char{
        return mapper["$a$b"]!!
    }
}