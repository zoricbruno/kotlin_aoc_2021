package day07.crabs.distance

import kotlin.math.abs

class ManhattanDistance : DistanceCalculator {
    override fun calculateDistance(a: Int, b: Int): Int {
        return abs(a - b)
    }
}