package day05.mapping.lines.creation

import day05.mapping.lines.*
import day05.mapping.lines.types.*
import day05.mapping.points.Point

class StraightLineCreator : LineCreator {
    override fun createLine(a: Point, b: Point): Line {
        if (a.x == b.x) {
            if (a.y < b.y) {
                return HorizontalLine(a, b)
            } else if (a.y > b.y)
                return InvertedHorizontalLine(a, b)
        }

        if (a.y == b.y) {
            if (a.x < b.x) {
                return VerticalLine(a, b)
            } else if (a.x > b.x)
                return InvertedVerticalLine(a, b)
        }

        return EmptyLine(a, b)
    }
}