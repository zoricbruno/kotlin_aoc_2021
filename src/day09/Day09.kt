package day09

import day09.lava.HeightMapParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("09", "Day09_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 1134)

    val input = readInput("09", "Day09")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    return HeightMapParser().parse(input).calculateRisk()
}

fun part2(input: List<String>): Int {
    return HeightMapParser().parse(input).findAreaOfNLargestBasins(3)
}

