package day08.displays

class SignalToDigitMapper {

    private val displayToValueMap: MutableMap<Set<Char>, Int> = mutableMapOf()

    // Default mapping:
    init {
        "abcefg" to 0
        "cf" to 1
        "acdeg" to 2
        "acdfg" to 3
        "bcdf" to 4
        "abdfg" to 5
        "abdefg" to 6
        "acf" to 7
        "abcdefg" to 8
        "abdcfg" to 9
    }


    fun createMapping(signalPatterns: List<String>) {
        displayToValueMap.clear()

        val one = signalPatterns.first { it.length == 2 }.toSet()
        val four = signalPatterns.first { it.length == 4 }.toSet()
        val seven = signalPatterns.first { it.length == 3 }.toSet()
        val eight = signalPatterns.first { it.length == 7 }.toSet()

        val fiveSegmentsOn = signalPatterns.filter { it.length == 5 }.map { it.toSet() }
        val centralThreeLines = (fiveSegmentsOn.reduce { a, b -> a.intersect(b) }) - one

        val three = one + centralThreeLines
        val nine = three + four
        val zero = eight - (four.intersect(centralThreeLines))

        val sixSegmentsOn = signalPatterns.filter { it.length == 6 }.map { it.toSet() }
        val five = eight - (sixSegmentsOn.map { eight - it }.reduce { a, b -> a + b } - four.intersect(centralThreeLines))
        val six = five + (eight - nine)
        val two = centralThreeLines + (eight - six) + (eight - nine)

        displayToValueMap[zero] = 0
        displayToValueMap[one] = 1
        displayToValueMap[two] = 2
        displayToValueMap[three] = 3
        displayToValueMap[four] = 4
        displayToValueMap[five] = 5
        displayToValueMap[six] = 6
        displayToValueMap[seven] = 7
        displayToValueMap[eight] = 8
        displayToValueMap[nine] = 9
    }

    fun map(input: String): Int {
        return displayToValueMap[input.toSet()] ?: throw NoSuchElementException()
    }
}