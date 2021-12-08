package day07.crabs.distance

import kotlin.math.abs

class CrabDistance : DistanceCalculator {
    override fun calculateDistance(a: Int, b: Int): Int {
        return (0..abs(a - b)).sum()
    }
}