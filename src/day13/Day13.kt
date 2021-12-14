package day13

import day13.foil.Foil
import day13.foil.parsing.FoilParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("13", "Day13_test")
    check(part1(testInput) == 17)
    check(part2(testInput) == 16)

    val input = readInput("13", "Day13")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val parser = FoilParser()
    val sharpLocations = parser.parseSharpLocations(input)
    val folds = parser.parseFolds(input)
    val foil = Foil(sharpLocations)
    foil.fold(folds[0])
    return foil.getTotalPoints()
}

fun part2(input: List<String>): Int {
    val parser = FoilParser()
    val sharpLocations = parser.parseSharpLocations(input)
    val folds = parser.parseFolds(input)
    val foil = Foil(sharpLocations)
    for (fold in folds)
        foil.fold(fold)
    println(foil)
    return foil.getTotalPoints()
}

