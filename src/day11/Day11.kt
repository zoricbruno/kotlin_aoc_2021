package day11

import day11.dumbo.OctopusParser
import day11.dumbo.OctopusPopulation
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("11", "Day11_test")
    check(part1(testInput) == 1656)
    check(part2(testInput) == 195)

    val input = readInput("11", "Day11")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val octopuses = OctopusParser().parse(input)
    val population = OctopusPopulation(octopuses)
    population.passTime(100)
    return population.getTotalFlashes()
}

fun part2(input: List<String>): Int {
    val octopuses = OctopusParser().parse(input)
    val population = OctopusPopulation(octopuses)
    val time = population.getTimeToSynchronize()
    return time
}

