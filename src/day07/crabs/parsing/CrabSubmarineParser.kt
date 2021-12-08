package day07.crabs.parsing

import day07.crabs.fleet.CrabFleet
import day07.crabs.fleet.CrabSubmarine

class CrabSubmarineParser {
    private val submarineSeparator = ','
    fun parse(input: String): List<CrabSubmarine> {
        return input.split(submarineSeparator)
            .map { CrabSubmarine(it.toInt()) }
    }
}

