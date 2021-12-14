package day12.mapping.path

data class Path(
    val from: String,
    val to: String,
) {
    companion object {
        val startNode = "start"
        val endNode = "end"
    }

    fun inverse(): Path = Path(to, from)
    fun isStartOrEnd(): Boolean {
        if (from == startNode || to == endNode) {
            return true
        }
        return false
    }

    fun isInversedStartOrEnd(): Boolean {
        if (from == endNode || to == startNode) {
            return true
        }
        return false
    }
}