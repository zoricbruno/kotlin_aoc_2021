package day06.fish

import java.util.*

class FishSchool {
    private val initialSchool = mutableListOf<LanternFish>()

    fun add(fish: List<LanternFish>) = initialSchool.addAll(fish)

    fun howManyWillSpawnIn(days: Int): Long {

        val fishAtStages = MutableList(LanternFish.DaysUntilFirstSpawn) { 0L }
        for (fish in initialSchool) {
            fishAtStages[fish.spawnsIn] += 1L
        }

        repeat(days) {
            Collections.rotate(fishAtStages, -1)
            fishAtStages[6] += fishAtStages[8]
        }
        return fishAtStages.sum()
    }
}