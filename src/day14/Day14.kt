package day14

import day14.polymerization.PolymerizatorParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("14", "Day14_test")
    check(part1(testInput) == 1588L)
    check(part2(testInput) == 2188189693529L)

    val input = readInput("14", "Day14")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Long {
    val parser = PolymerizatorParser()
    val polymerizer = parser.parsePolymerizer(input)
    val polymer = parser.parsePolymer(input)
    return polymerizer.findDifferenceBetweenLetters(polymer, 10)
}

fun part2(input: List<String>): Long {
    val parser = PolymerizatorParser()
    val polymerizer = parser.parsePolymerizer(input)
    val polymer = parser.parsePolymer(input)
    return polymerizer.findDifferenceBetweenLetters(polymer, 40)}

