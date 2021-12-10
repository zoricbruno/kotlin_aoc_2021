package day10.test

import day10.navigation.Navigator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NavigatorTest{

    @Test
    fun findError(){
        val line = "{([(<{}[<>[]}>{[]{[(<()>"
        val expected = '}'
        val navigator = Navigator()
        val actual = navigator.findError(line)
        assertEquals(expected, actual)
    }

    @Test
    fun findCompletingChunk_forIncompliteLine_returnsCorrectCompletion(){
        val line = "[({(<(())[]>[[{[]{<()<>>"
        val expected = "}}]])})]"
        val navigator = Navigator()
        val actual = navigator.findCompletingChunk(line)
        assertEquals(expected, actual)
    }

    @Test
    fun mapCompletingChunkToPoints(){
        val chunk = "}}]])})]"
        val expected = 288957
        val actual = Navigator().mapCompletingChunkToPoints(chunk)
        assertEquals(expected, actual)
    }
}