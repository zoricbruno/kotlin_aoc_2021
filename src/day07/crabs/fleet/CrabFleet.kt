package day07.crabs.fleet

import kotlin.math.abs

class CrabFleet() {
    private val submarines = mutableListOf<CrabSubmarine>()
    fun addSubmarines(submarines: List<CrabSubmarine>) {
        this.submarines.addAll(submarines)
    }

    fun getBestPosition(): Int {
        return submarines.sortedBy { it.position }
            .let {
                if (it.size % 2 == 0) {
                    (it[it.size / 2].position + it[it.size / 2 - 1].position) / 2
                } else {
                    it[it.size / 2].position
                }
            }
    }

    fun getBestPositionCost(): Int {
        val bestPosition = getBestPosition()
        return submarines.sumOf { abs(it.position - bestPosition) }
    }
}