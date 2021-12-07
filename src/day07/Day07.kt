package day07

import day07.crabs.fleet.CrabSubmarine
import day07.crabs.parsing.CrabSubmarineParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("07", "Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 0)

    val input = readInput("07", "Day07")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val parser = CrabSubmarineParser()
    val fleet = parser.parse(input.first())
    return fleet.getBestPositionCost()
}

fun part2(input: List<String>): Int {
    return 0
}

