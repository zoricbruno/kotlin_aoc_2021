package day03

import day03.diagnostics.ReportGenerator
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("03", "Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("03", "Day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int = ReportGenerator().generateReport(input).calculatePowerConsumption()

fun part2(input: List<String>): Int = ReportGenerator().generateRating(input).calculateLifeSupportRating()

