package day07.crabs.fleet

import day07.crabs.distance.DistanceCalculator

class CrabFleet(
    private val distanceCalculator: DistanceCalculator,
    private val submarines: MutableList<CrabSubmarine> = mutableListOf()
) {
    fun addSubmarines(submarines: List<CrabSubmarine>) {
        this.submarines.addAll(submarines)
    }

    fun getCostOfBestPosition(): Int {
        val smallestDistance = (1 .. submarines.maxOf { it.position })
            .minOf { position ->
                submarines.sumOf { crabSubmarine ->
                    distanceCalculator.calculateDistance(position, crabSubmarine.position) }
            }
        return smallestDistance
    }
}