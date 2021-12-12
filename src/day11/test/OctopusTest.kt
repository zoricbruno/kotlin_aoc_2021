package day11.test

import day11.dumbo.Octopus
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class OctopusTest{

    @Test
    fun onTimePass_octopus_hasCorrectEnergy(){
        val octopus = Octopus()
        for (i in 0 .. 10){
            octopus.increaseEnergy()
            if(octopus.energy == 10) octopus.onDayComplete()
        }
        assertEquals(1, octopus.energy)
        assertEquals(1, octopus.flashes)
        for (i in 0 .. 15){
            octopus.increaseEnergy()
            if(octopus.energy == 10) octopus.onDayComplete()
        }
        assertEquals(7, octopus.energy)
        assertEquals(2, octopus.flashes)
    }
}