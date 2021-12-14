package day12.mapping.cave_filtering

import day12.mapping.path.Path

class SingleRepeatableSmallCaveFilter : CaveInclusionFilter {
    override fun shouldBeAddedToRoute(neighbour: String, currentRoute: MutableList<String>): Boolean {
        if (neighbour.uppercase() == neighbour) return true
        if (!currentRoute.contains(neighbour)) {
            return true
        } else {
            val smallRooms = currentRoute.filter { it.lowercase() == it }
                .groupingBy { it }
                .eachCount() - Path.startNode - Path.endNode
            if (smallRooms.maxOf { it.value } == 2)
                return false
        }
        return true
    }
}