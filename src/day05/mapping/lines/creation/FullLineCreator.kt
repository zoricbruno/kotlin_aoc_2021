package day05.mapping.lines.creation

import day05.mapping.lines.*
import day05.mapping.lines.types.*
import day05.mapping.points.Point

open class FullLineCreator : LineCreator() {
    override fun createLine(a: Point, b: Point): Line {
        if(isLeftToRightDownwardDiagonalLine(a,b)) return LeftToRightDownwardLine(a,b)
        if(isLeftToRightUpwardDiagonalLine(a,b)) return LeftToRightUpwardLine(a,b)
        if(isRightToLeftDownwardDiagonalLine(a,b)) return RightToLeftDownwardLine(a,b)
        if(isRightToLeftUpwardDiagonalLine(a,b)) return RightToLeftUpwardLine(a,b)
        return super.createLine(a, b)
    }

    private fun isLeftToRightDownwardDiagonalLine(a: Point, b: Point) = a.x < b.x && a.y < b.y
    private fun isRightToLeftDownwardDiagonalLine(a: Point, b: Point) = a.x < b.x && a.y > b.y
    private fun isLeftToRightUpwardDiagonalLine(a: Point, b: Point) = a.x > b.x && a.y < b.y
    private fun isRightToLeftUpwardDiagonalLine(a: Point, b: Point) = a.x > b.x && a.y > b.y
}