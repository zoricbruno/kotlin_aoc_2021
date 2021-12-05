package day05.mapping.lines.types

import day05.mapping.lines.Line
import day05.mapping.points.Point

class EmptyLine(a: Point, b: Point) : Line(a,b) {
    override fun getAllPoints(): List<Point> {
        return listOf()
    }
}
