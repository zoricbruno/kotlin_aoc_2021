package day03.diagnostics

data class Rating (
    val ratingO2: Int = 0,
    val ratingCo2: Int = 0
        ){
    fun calculateLifeSupportRating(): Int = ratingCo2 * ratingO2
}