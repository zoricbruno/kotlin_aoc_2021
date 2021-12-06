package day05.mapping.lines.creation

import day05.mapping.lines.*
import day05.mapping.lines.types.*
import day05.mapping.points.Point

class FullLineCreator : LineCreator() {
    override fun createLine(a: Point, b: Point): Line {

        if(isHorizontal(a,b)) return HorizontalLine(a,b)
        if(isInvertedHorizontal(a,b)) return InvertedHorizontalLine(a,b)
        if(isVertical(a,b)) return VerticalLine(a,b)
        if(isInvertedVertical(a,b)) return InvertedVerticalLine(a,b)

        if (isLeftToRightDownwardDiagonalLine(a,b)) return LeftToRightDownwardLine(a, b)
        if (isRightToLeftDownwardDiagonalLine(a,b)) return RightToLeftDownwardLine(a, b)
        if (isLeftToRightUpwardDiagonalLine(a,b)) return LeftToRightUpwardLine(a, b)
        if (isRightToLeftUpwardDiagonalLine(a,b)) return RightToLeftUpwardLine(a, b)

        return EmptyLine(a, b)
    }
}