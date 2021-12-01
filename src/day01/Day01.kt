package day01

import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("01", "Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("01", "Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val numbers = input.map { it.toInt() }
    return countAdjacentIncreases(numbers)
}

fun part2(input: List<String>): Int {
    val numbers = input.map { it.toInt() }
    val windowSize = 3
    return countIncreasingWindowSums(numbers, windowSize)
}

// Could be done with a loop which is more readable, decided to play around with collections
// sumOf migration - ambiguity problem with literals, so a deprecated method is still used
// see: https://youtrack.jetbrains.com/issue/KT-46360
fun countAdjacentIncreases(numbers: List<Int>): Int =
    (1 until numbers.size).sumBy { if (numbers[it] > numbers[it - 1]) 1 else 0 }

fun countIncreasingWindowSums(numbers: List<Int>, windowSize: Int): Int =
    countAdjacentIncreases(numbers.windowed(windowSize) { it.sum() })