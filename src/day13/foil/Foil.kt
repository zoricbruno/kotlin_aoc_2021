package day13.foil

class Foil(private val sharpLocations: List<SharpLocation>) {

    private var width = sharpLocations.maxOf { it.column } + 1
    private var height = sharpLocations.maxOf { it.row } + 1

    fun fold(fold: Fold) {
        fold.fold(sharpLocations)
        width = fold.getWidth(width)
        height = fold.getHeight(height)
    }

    private fun getMap(): List<List<Int>> {
        val map = mutableListOf<MutableList<Int>>()
        for (i in 0 until height) {
            map.add(mutableListOf())
            for (j in 0 until width) {
                map[i].add(0)
            }
        }
        for (sharp in sharpLocations) {
            map[sharp.row][sharp.column] = 1
        }
        return map
    }

    fun getTotalPoints(): Int = getMap().sumOf { it.sum() }

    override fun toString(): String = getMap().joinToString("\n") { it -> it.joinToString("") }
}