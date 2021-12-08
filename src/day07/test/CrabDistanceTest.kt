package day07.test

import day07.crabs.distance.CrabDistance
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CrabDistanceTest{

    @Test
    @DisplayName("Crab distance between values is correct")
    fun crabDistance_when1and5_distanceIs10(){
        val distance = CrabDistance()
        val expected = 45
        val actual = distance.calculateDistance(14,5)
        assertEquals(expected, actual)
    }
}