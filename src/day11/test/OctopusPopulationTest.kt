package day11.test

import day11.dumbo.Octopus
import day11.dumbo.OctopusPopulation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class OctopusPopulationTest{
    @Test
    fun population_whenStepsPass_flashesCorrectNumberOfTimes(){

        val octopuses = listOf(
            listOf(1,1,1,1,1),
            listOf(1,9,9,9,1),
            listOf(1,9,1,9,1),
            listOf(1,9,9,9,1),
            listOf(1,1,1,1,1),
        )

        val population = OctopusPopulation(octopuses.map { it.map { energy -> Octopus(energy) } })
        population.passTime(2)
        assertEquals(9, population.getTotalFlashes())
    }
}