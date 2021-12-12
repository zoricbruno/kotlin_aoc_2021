package day11.dumbo

import java.util.*

class OctopusPopulation(
    private val population: List<List<Octopus>>
) {
    fun getTotalFlashes(): Int {
        return population.sumOf { it.sumOf { it.flashes } }
    }

    fun getTimeToSynchronize(): Int {
        var days = 0
        while (getTotalEnergy() != 0){
            passDay()
            days++
        }
        return days
    }

    private fun getTotalEnergy(): Int{
        return population.sumOf { it.sumOf { it.energy } }
    }

    fun passTime(days: Int) {
        repeat(days) {
            passDay()
        }
    }

    private fun passDay() {
        tickAll()
        handleNeighbours()
        onDayComplete()
    }

    private fun onDayComplete() {
        population.forEach { it.forEach { it.onDayComplete() } }
    }

    private fun tickAll() {
        population.forEach { it.forEach { octopus -> octopus.increaseEnergy() } }
    }

    private fun handleNeighbours() {
        val flashed = LinkedList<Point>()
        for (i in population.indices) {
            for (j in population.indices) {
                if (population[i][j].energy == 10) {
                    flashed.add(Point(i, j))
                }
            }
        }
        while (!flashed.isEmpty()) {
            val current = flashed.poll()
            val neighbours = current.findNeighbours()
            for (neighbour in neighbours) {
                try {
                    population[neighbour.x][neighbour.y].increaseEnergy()
                    if (population[neighbour.x][neighbour.y].energy == 10) {
                        flashed.add(Point(neighbour.x, neighbour.y))
                    }
                } catch (_: IndexOutOfBoundsException) {
                }
            }
        }
    }
}