package day02

import day02.submarine.Submarine
import day02.submarine.WeaponizedSubmarinePosition
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("02", "Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("02", "Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val submarine = Submarine()
    input.forEach { submarine.move(it) }
    return submarine.getTotalPosition()
}

fun part2(input: List<String>): Int {
    val submarine = Submarine(position = WeaponizedSubmarinePosition())
    input.forEach { submarine.move(it) }
    return submarine.getTotalPosition()
}