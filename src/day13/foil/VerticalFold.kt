package day13.foil

class VerticalFold(location: Int) : Fold(location) {
    override fun fold(sharpLocations: List<SharpLocation>) {
        sharpLocations.forEach {
            if (it.column > location)
                it.column = location - (it.column - location)
        }
    }

    override fun getWidth(width: Int): Int = width / 2

    override fun getHeight(height: Int): Int = height
}