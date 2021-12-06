package day05.mapping.lines.creation

import day05.mapping.lines.Line
import day05.mapping.lines.types.EmptyLine
import day05.mapping.lines.types.HorizontalLine
import day05.mapping.points.Point
import kotlin.reflect.KClass

abstract class LineCreator {

    val lineCreators = mutableMapOf<(Point, Point) -> Boolean, LineFactory>()

    fun createLine(a: Point, b: Point): Line {
        for (lineCreator in lineCreators) {
            if (lineCreator.key(a, b)) return lineCreator.value.create(a, b)
        }
        return EmptyLine(a, b)
    }

    protected fun addCreator(check: (Point, Point) -> Boolean, factory: LineFactory){
        lineCreators[check] = factory
    }

    protected fun isHorizontal(a: Point, b: Point): Boolean = a.x == b.x && a.y < b.y
    protected fun isInvertedHorizontal(a: Point, b: Point) = a.x == b.x && a.y > b.y
    protected fun isVertical(a: Point, b: Point) = a.y == b.y && a.x < b.x
    protected fun isInvertedVertical(a: Point, b: Point) = a.y == b.y && a.x > b.x
    protected fun isLeftToRightDownwardDiagonalLine(a: Point, b: Point) = a.x < b.x && a.y < b.y
    protected fun isRightToLeftDownwardDiagonalLine(a: Point, b: Point) = a.x < b.x && a.y > b.y
    protected fun isLeftToRightUpwardDiagonalLine(a: Point, b: Point) = a.x > b.x && a.y < b.y
    protected fun isRightToLeftUpwardDiagonalLine(a: Point, b: Point) = a.x > b.x && a.y > b.y
}

abstract class LineFactory {
    abstract fun create(a: Point, b: Point): Line
}