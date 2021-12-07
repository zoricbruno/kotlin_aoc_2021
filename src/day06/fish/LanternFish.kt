package day06.fish

data class LanternFish(
    private var daysUntilSpawn: Int = DaysUntilFirstSpawn - 1,
) {
    val spawnsIn: Int
        get() = daysUntilSpawn

    fun passDay() {
        daysUntilSpawn = if (daysUntilSpawn == 0) (DaysUntilChild - 1) else daysUntilSpawn - 1
    }

    fun shouldSpawnOnNext() = daysUntilSpawn == 0

    companion object {
        const val DaysUntilChild = 7
        const val DaysUntilFirstSpawn = 9
    }
}