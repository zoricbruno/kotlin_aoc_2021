package day14.polymerization

class Polymerizer(
    private val conversion: Map<String, Char>
) {
    fun findDifferenceBetweenLetters(polymer: String, steps: Int): Long {

        // Create inital map:
        var occurrenceMap = mutableMapOf<String, Long>()
        polymer.windowed(2).forEach {
            occurrenceMap[it] = occurrenceMap.getOrDefault(it, 0) + 1
        }

        // Create a new occurence map based on the old:
        repeat(steps){
            occurrenceMap = getNextOccurrenceMap(occurrenceMap)
        }

        // Count all letters in pairs as the times first letter occured
        val charCounts = getCharacterCounts(occurrenceMap)

        // Only first letters considered earlier, add the last letter:
        val last = polymer.last()
        charCounts[last] = charCounts.getOrDefault(last, 0) + 1

        // Find the difference between the most and least often:
        return charCounts.maxOf { it.value } - charCounts.minOf { it.value }
    }

    private fun getNextOccurrenceMap(occurrenceMap: MutableMap<String, Long>): MutableMap<String, Long> {
        val newOccurrenceMap = mutableMapOf<String, Long>()
        occurrenceMap.forEach {
            val char = conversion[it.key]
            val firstPair: String = "${it.key[0]}${char}"
            val secondPair: String = "${char}${it.key[1]}"
            newOccurrenceMap[firstPair] = newOccurrenceMap.getOrDefault(firstPair, 0) + it.value
            newOccurrenceMap[secondPair] = newOccurrenceMap.getOrDefault(secondPair, 0) + it.value
        }
        return newOccurrenceMap
    }

    private fun getCharacterCounts(occurrenceMap: Map<String, Long>): MutableMap<Char, Long>{
        // Count characters.
        val charCounts = mutableMapOf<Char, Long>()
        for (item in occurrenceMap) {
            charCounts[item.key.first()] = charCounts.getOrDefault(item.key.first(), 0) + item.value
        }
        return charCounts
    }
}