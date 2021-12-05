package day05.mapping.parsing

import day05.mapping.lines.*
import day05.mapping.lines.creation.LineCreator
import day05.mapping.points.Point

class InputParser(
    private val lineCreator: LineCreator
) {
    private val pointSeparator = "\\s+->\\s+".toRegex()
    private val coordinateSeparator = ","

    fun parse(input: List<String>): List<Line> {
        return input.map { parse(it) }
    }

    private fun parse(input: String): Line {
        val pointInputs = input.split(pointSeparator)
        val x = parsePoint(pointInputs.first())
        val y = parsePoint(pointInputs.last())
        return lineCreator.createLine(x, y)
    }

    private fun parsePoint(input: String): Point {
        val xCoordinates = input.split(coordinateSeparator).map { it.toInt() }
        return Point(xCoordinates.first(), xCoordinates.last())
    }
}

