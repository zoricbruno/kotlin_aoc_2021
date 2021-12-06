package day05.mapping.lines.creation

import day05.mapping.lines.Line
import day05.mapping.lines.types.*
import day05.mapping.points.Point

open class LineCreator {

    open fun createLine(a: Point, b: Point): Line {
        if(isHorizontal(a,b)) return HorizontalLine(a,b)
        if(isInvertedHorizontal(a,b)) return InvertedHorizontalLine(a,b)
        if(isVertical(a,b)) return VerticalLine(a,b)
        if(isInvertedVertical(a,b)) return InvertedVerticalLine(a,b)
        return EmptyLine(a, b)
    }

    private fun isHorizontal(a: Point, b: Point): Boolean = a.x == b.x && a.y < b.y
    private fun isInvertedHorizontal(a: Point, b: Point) = a.x == b.x && a.y > b.y
    private fun isVertical(a: Point, b: Point) = a.y == b.y && a.x < b.x
    private fun isInvertedVertical(a: Point, b: Point) = a.y == b.y && a.x > b.x
}