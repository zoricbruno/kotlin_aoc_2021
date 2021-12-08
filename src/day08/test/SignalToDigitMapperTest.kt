package day08.test

import day08.displays.SegmentParser
import day08.displays.SignalToDigitMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SignalToDigitMapperTest {

    @Test
    fun map() {
        val display =
            SegmentParser().parse("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf")
        val mapper = SignalToDigitMapper().apply { createMapping(display.signalPatterns) }

        assertEquals(mapper.map("cagedb"), 0)
        assertEquals(mapper.map("ab"), 1)
        assertEquals(mapper.map("gcdfa"), 2)
        assertEquals(mapper.map("fbcad"), 3)
        assertEquals(mapper.map("eafb"), 4)
        assertEquals(mapper.map("cdfbe"), 5)
        assertEquals(mapper.map("cdfgeb"), 6)
        assertEquals(mapper.map("dab"), 7)
        assertEquals(mapper.map("acedgfb"), 8)
        assertEquals(mapper.map("cefabd"), 9)
    }
}