package day07.crabs.parsing

import day07.crabs.fleet.CrabFleet
import day07.crabs.fleet.CrabSubmarine

class CrabSubmarineParser {
    private val submarineSeparator = ','
    fun parse(input: String): CrabFleet {
        val fleet = CrabFleet()
        fleet.addSubmarines(
            input.split(submarineSeparator)
                .map { CrabSubmarine(it.toInt()) }
        )
        return fleet
    }
}

