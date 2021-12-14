package day12.mapping.cave_filtering

class NonRepeatingSmallCaveFilter : CaveInclusionFilter {
    override fun shouldBeAddedToRoute(neighbour: String, currentRoute: MutableList<String>): Boolean {
        if (neighbour.lowercase() == neighbour && currentRoute.contains(neighbour)) {
            return false
        }
        return true
    }
}