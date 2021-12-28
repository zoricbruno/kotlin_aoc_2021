package day17.test

import day17.probing.Probe
import day17.probing.TargetArea
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TargetTest {

    @Test
    fun isInTargetArea() {
        val probe1 = Probe(0,0,0,0)
        val probe2 = Probe(0,0,20,-5)
        val target = TargetArea(20, 30, -10, -5)
        assertFalse(target.isInTargetArea(probe1))
        assertTrue(target.isInTargetArea(probe2))
    }

    @Test
    fun isOvershot(){
        val probe1 = Probe(0,0,0,0)
        val probe2 = Probe(0,0,20,-5)
        val probe3 = Probe(0,0,20,-11)
        val target = TargetArea(20, 30, -10, -5)
        assertFalse(target.isOvershot(probe1))
        assertFalse(target.isOvershot(probe2))
        assertTrue(target.isOvershot(probe3))
    }
}