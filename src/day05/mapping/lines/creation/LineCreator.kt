package day05.mapping.lines.creation

import day05.mapping.lines.Line
import day05.mapping.points.Point

interface LineCreator {
    fun createLine(a: Point, b: Point): Line
}