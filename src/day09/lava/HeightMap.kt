package day09.lava

import java.util.*
import kotlin.collections.ArrayDeque

class HeightMap(
    private val map: List<List<Int>>
) {
    private val maxHighPointValue = 9

    fun calculateRisk(): Int {
        return findLowPoints().sumOf { map[it.x][it.y] + 1 }
    }

    fun findAreaOfNLargestBasins(n: Int): Int {
        return findBasins().map { it.size }.sortedDescending().take(n).reduce { a, b -> a * b }
    }

    private fun findBasins(): List<List<Point>> {
        val basins = mutableListOf<List<Point>>()
        val lowPoints = findLowPoints()
        for (point in lowPoints) {
            basins.add(findBasin(point))
        }
        return basins
    }

    private fun findBasin(point: Point): List<Point> {
        // To find the basins, flood-fill algorithm is used
        // See: https://www.baeldung.com/cs/flood-fill-algorithm
        val basinPoints = mutableListOf<Point>()
        val visitedPoints = mutableListOf<Point>().apply { add(point) }
        val pointsToProcess = LinkedList<Point>().apply { add(point) }

        while (!pointsToProcess.isEmpty()) {
            val currentPoint = pointsToProcess.poll()
            basinPoints.add(currentPoint)
            val deltaX = arrayOf(-1, 0, 0, 1)
            val deltaY = arrayOf(0, -1, 1, 0)
            for (i in deltaX.indices) {
                val pointToConsider = Point(currentPoint.x + deltaX[i], currentPoint.y + deltaY[i])
                if (doesFlow(currentPoint, pointToConsider, visitedPoints)) {
                    visitedPoints.add(pointToConsider)
                    pointsToProcess.add(pointToConsider)
                }
            }
        }
        return basinPoints
    }

    private fun doesFlow(point: Point, newPoint: Point, visitedPoints: List<Point>): Boolean {
        if (newPoint.x < 0 || newPoint.x >= map.size) return false
        if (newPoint.y < 0 || newPoint.y >= map[newPoint.x].size) return false
        if (map[newPoint.x][newPoint.y] == maxHighPointValue) return false
        if (visitedPoints.contains(newPoint)) return false
        if (map[newPoint.x][newPoint.y] <= map[point.x][point.y]) return false
        return true
    }

    private fun findLowPoints(): List<Point> {
        val points = mutableListOf<Point>()
        for (x in map.indices) {
            for (y in map[x].indices) {
                if (isLowPoint(x, y)) {
                    points.add(Point(x, y))
                }
            }
        }
        return points
    }

    private fun isLowPoint(x: Int, y: Int): Boolean {
        for (deltaX in -1..1) {
            for (deltaY in -1..1) {
                try {
                    if (deltaX == 0 && deltaY == 0) continue
                    if (map[x + deltaX][y + deltaY] <= map[x][y]) {
                        return false
                    }
                } catch (_: IndexOutOfBoundsException) {
                }
            }
        }
        return true;
    }
}