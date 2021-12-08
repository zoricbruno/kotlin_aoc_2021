package day07

import day07.crabs.distance.CrabDistance
import day07.crabs.fleet.CrabFleet
import day07.crabs.distance.ManhattanDistance
import day07.crabs.parsing.CrabSubmarineParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("07", "Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("07", "Day07")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val parser = CrabSubmarineParser()
    val submarines = parser.parse(input.first())
    val fleet = CrabFleet(ManhattanDistance()).apply {
        addSubmarines(submarines)
    }
    return fleet.getCostOfBestPosition()
}

fun part2(input: List<String>): Int {
    val parser = CrabSubmarineParser()
    val submarines = parser.parse(input.first())
    val fleet = CrabFleet(CrabDistance()).apply {
        addSubmarines(submarines)
    }
    return fleet.getCostOfBestPosition()
}

