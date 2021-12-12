package day11.dumbo

data class Point(
    val x: Int,
    val y: Int
) {
    fun findNeighbours(): List<Point> {
        return listOf(-1, -1, -1, 0, 0, 1, 1, 1)
            .zip(listOf(-1, 0, 1, -1, 1, -1, 0, 1))
            .map { Point(it.first, it.second) }
            .map { Point(x + it.x, y + it.y) }
    }
}