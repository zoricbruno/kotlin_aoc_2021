package day05.mapping.lines

import day05.mapping.points.Point

abstract class Line(val a: Point, val b: Point){
    abstract fun getAllPoints(): List<Point>

    protected fun getPointsOnHorizontalLine(a: Point, b: Point): List<Point>{
        val points = mutableListOf<Point>()
        val row = a.x
        for (column in a.y .. b.y){
            points.add(Point(row, column))
        }
        return points
    }

    protected fun getPointsOnVerticalLine(a: Point, b: Point): List<Point>{
        val points = mutableListOf<Point>()
        val column = a.y
        for (row in a.x .. b.x){
            points.add(Point(row, column))
        }
        return points
    }

    protected fun getPointsOnDiagonalDownLine(a: Point, b: Point): List<Point>{
        val points = mutableListOf<Point>()
        var row = a.x
        var column = a.y
        while (row <= b.x && column <= b.y){
            points.add(Point(row, column))
            row++
            column++
        }
        return points
    }

    protected fun getPointsOnDiagonalUpLine(a: Point, b: Point): List<Point>{
        val points = mutableListOf<Point>()
        var row = a.x
        var column = a.y
        while (row >= b.x && column <= b.y){
            points.add(Point(row, column))
            row--
            column++
        }
        return points
    }
}