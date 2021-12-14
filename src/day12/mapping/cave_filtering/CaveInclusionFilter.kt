package day12.mapping.cave_filtering

interface CaveInclusionFilter {
    fun shouldBeAddedToRoute(neighbour: String, currentRoute: MutableList<String>): Boolean
}

