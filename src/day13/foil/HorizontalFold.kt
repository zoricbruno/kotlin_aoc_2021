package day13.foil

class HorizontalFold(location: Int) : Fold(location) {
    override fun fold(sharpLocations: List<SharpLocation>) {
        sharpLocations.forEach {
            if (it.row > location)
                it.row = location - (it.row - location)
        }
    }

    override fun getWidth(width: Int): Int = width

    override fun getHeight(height: Int): Int = height / 2
}