package day05

import day05.mapping.FloorMap
import day05.mapping.lines.creation.FullLineCreator
import day05.mapping.parsing.InputParser
import day05.mapping.lines.creation.StraightLineCreator
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("05", "Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("05", "Day05")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val map = FloorMap()
    val lineCreator = StraightLineCreator()
    val inputParser = InputParser(lineCreator)
    val directions = inputParser.parse(input)
    directions.forEach{ map.add(it)}
    return map.countDangerous()
}

fun part2(input: List<String>): Int {
    val map = FloorMap()
    val lineCreator = FullLineCreator()
    val inputParser = InputParser(lineCreator)
    val directions = inputParser.parse(input)
    directions.forEach{ map.add(it)}
    return map.countDangerous()
}

