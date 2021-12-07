package day06

import day06.fish.FishSchool
import day06.fish.parsing.FishInputParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("06", "Day06_test")
    check(part1(testInput, 18) == 26L)
    check(part1(testInput, 80) == 5934L)
    check(part2(testInput, 256) == 26984457539)

    val input = readInput("06", "Day06")
    println("Part 1: ${part1(input, 80)}")
    println("Part 2: ${part2(input, 256)}")
}

fun part1(input: List<String>, days: Int): Long {
    val parser = FishInputParser()
    val school = FishSchool()
    school.add(parser.parseMultiple(input.first()))
    return school.howManyWillSpawnIn(days)
}

fun part2(input: List<String>, days: Int): Long {
    val parser = FishInputParser()
    val school = FishSchool()
    school.add(parser.parseMultiple(input.first()))
    return school.howManyWillSpawnIn(days)
}

