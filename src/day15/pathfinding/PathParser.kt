package day15.pathfinding

class PathParser {
    fun parse(input: List<String>): List<Vertex> {
        return extractVertices(mapInputToInt(input))
    }

    fun parseExtended(input: List<String>): List<Vertex> {
        val vertices = mutableListOf<Vertex>()
        val risks = mapInputToInt(input)
        val extendedRisks = repeatRisks(5, risks)
        return extractVertices(extendedRisks)
    }

    private fun repeatRisks(times: Int, risks: List<List<Int>>): List<List<Int>> {
        val extendedRisks = mutableListOf<List<Int>>()
        for (row in risks) {
            val extendedRow = mutableListOf<Int>()
            for (time in 0 until times) {
                for (element in row) {
                    var value = (element + time) % 10 + (element + time) / 10
                    extendedRow.add(value)
                }
            }
            extendedRisks.add(extendedRow)
        }

        val currentRows = extendedRisks.size
        for (time in 1 until times) {
            for (i in 0 until currentRows) {
                val extendedRow = extendedRisks[i].toMutableList().map { (it + time) % 10 + (it + time) / 10}
                extendedRisks.add(extendedRow)
            }
        }
        return extendedRisks
    }

    private fun extractVertices(risks: List<List<Int>>): List<Vertex> {
        val vertices = mutableListOf<Vertex>()
        risks.indices.forEach { i ->
            risks[i].indices.forEach { j ->
                val vertex = createVertex(i, j, risks)
                vertices.add(vertex)
            }
        }
        return vertices
    }

    private fun mapInputToInt(input: List<String>): List<List<Int>> {
        val risks = input.map {
            it.map {
                it.toString().toInt()
            }
        }
        return risks
    }

    private fun createVertex(i: Int, j: Int, risks: List<List<Int>>): Vertex {
        val vertex = Vertex(i, j)
        val deltaX = listOf<Int>(-1, 0, 0, 1)
        val deltaY = listOf<Int>(0, -1, 1, 0)
        for (delta in deltaX.indices) {
            try {
                val newI = i + deltaX[delta]
                val newJ = j + deltaY[delta]
                vertex.addNeighbour(Vertex(newI, newJ), risks[newI][newJ])
            } catch (e: IndexOutOfBoundsException) {

            }
        }
        return vertex
    }
}