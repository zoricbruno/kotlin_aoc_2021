package day12.mapping

import day12.mapping.path.Path.Companion.endNode
import day12.mapping.path.Path.Companion.startNode
import day12.mapping.cave_filtering.CaveInclusionFilter
import day12.mapping.path.Path
import java.util.*

open class CaveGraph(
    private val caveInclusionFilter: CaveInclusionFilter
) {
    private val nodes: MutableSet<String> = mutableSetOf()
    private val adjacency: MutableMap<String, MutableSet<String>> = mutableMapOf()

    fun addPaths(paths: List<Path>) {
        for (path in paths) {
            if (path.isStartOrEnd()) {
                addPath(path)
            } else if (path.isInversedStartOrEnd()) {
                addPath(path.inverse())
            } else {
                addPath(path)
                addPath(path.inverse())
            }
        }
    }

    private fun addPath(path: Path) {
        nodes.add(path.from)
        nodes.add(path.to)
        if (!adjacency.contains(path.from)) {
            adjacency[path.from] = mutableSetOf()
        }
        adjacency[path.from]!!.add(path.to)
    }

    // BFS is used, difference between tasks reflects in adding small caves or not.
    fun getAllRoutes(): List<List<String>> {
        val routes = mutableListOf<List<String>>()
        val queue = LinkedList<MutableList<String>>()
            .apply {
                add(mutableListOf(startNode))
            }
        while (!queue.isEmpty()) {
            val currentRoute = queue.poll()
            val lastInRoute = currentRoute.last()
            if (lastInRoute == endNode) {
                routes.add(currentRoute)
                continue
            }
            for (neighbour in adjacency[lastInRoute]!!) {
                if (caveInclusionFilter.shouldBeAddedToRoute(neighbour, currentRoute)) {
                    val newRoute = currentRoute.toMutableList().apply { add(neighbour) }
                    queue.push(newRoute)
                }
            }
        }
        return routes
    }
}