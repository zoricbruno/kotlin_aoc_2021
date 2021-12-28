package day15.pathfinding

class NavigationMap() {

    private val infinity: Int = Int.MAX_VALUE

    fun find(vertices: List<Vertex>, source: Vertex): Int {

        val distances = mutableMapOf<Vertex, Int>()
        val previousVertices = mutableMapOf<Vertex, Vertex?>()

        for (vertex in vertices) {
            distances[vertex] = infinity
            previousVertices[vertex] = null
        }

        distances[source] = 0

        val S = mutableListOf<Vertex>()
        val Q = vertices.toMutableList()

        while (Q.isNotEmpty()) {
            val nearestUnvisitedVertex = findNearestUnvisited(Q, distances)
            Q.remove(nearestUnvisitedVertex)
            S.add(nearestUnvisitedVertex)

            for (neighbour in nearestUnvisitedVertex.getNeighbours()) {
                if (distances[neighbour.key]!! > distances[nearestUnvisitedVertex]!! + neighbour.value) {
                    distances[neighbour.key] = distances[nearestUnvisitedVertex]!! + neighbour.value
                    previousVertices[neighbour.key] = nearestUnvisitedVertex
                }
            }
        }

        prettyPrintShortestRoutes(source, vertices, distances, previousVertices)
        return distances[vertices.last()]!!
    }

    private fun findNearestUnvisited(q: MutableList<Vertex>, distances: Map<Vertex, Int>): Vertex {
        var minVertex = q[0]
        for (vertex in q){
            if(distances[vertex]!! < distances[minVertex]!!){
                minVertex = vertex
            }
        }
        return minVertex
    }

    private fun prettyPrintShortestRoutes(
        source: Vertex,
        vertices: List<Vertex>,
        distances: Map<Vertex, Int>,
        previousCities: Map<Vertex, Vertex?>
    ) {
        for (vertex: Vertex in vertices) {
            var road: String = vertex.toString()
            var previousVertex: Vertex? = previousCities[vertex]
            while (previousVertex != null) {
                road = "$previousVertex -> $road"
                previousVertex = previousCities[previousVertex]
            }
            System.out.println(
                "Distance from " + source.toString() + " to "
                        + vertex.toString() + ": " + distances.get(vertex).toString() + " km"
            )
            println("Route: $road\n")
        }
    }
}

data class Vertex(
    val row: Int,
    val col: Int,
) {
    private val neighbourDistances = mutableMapOf<Vertex, Int>()

    fun addNeighbour(vertex: Vertex, distance: Int) {
        neighbourDistances[vertex] = distance
    }

    fun getNeighbours(): Map<Vertex, Int> = neighbourDistances

    override fun toString(): String {
        return "$row,$col"
    }
}


