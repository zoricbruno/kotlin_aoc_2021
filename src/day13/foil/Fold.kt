package day13.foil

abstract class Fold(val location: Int) {
    abstract fun fold(sharpLocations: List<SharpLocation>)
    abstract fun getWidth(width: Int): Int
    abstract fun getHeight(height: Int): Int
}
