package day10

import day09.lava.HeightMapParser
import day10.navigation.Navigator
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("10", "Day10_test")
    check(part1(testInput) == 26397)
    check(part2(testInput) == 288957L)

    val input = readInput("10", "Day10")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    return Navigator().calculateErrorPoints(input)
}

fun part2(input: List<String>): Long {
    return Navigator().calculateCompletionPoints(input)
}

