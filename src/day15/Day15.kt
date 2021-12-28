package day15

import day15.pathfinding.NavigationMap
import day15.pathfinding.PathParser
import day15.pathfinding.Vertex
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    var testInput = readInput("15", "Day15_test")
    check(part1(testInput) == 40)
    check(part2(testInput) == 315)

    val input = readInput("15", "Day15")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val map = NavigationMap()
    val cities = PathParser().parse(input)
    return map.find(cities, Vertex(0,0))
}

fun part2(input: List<String>): Int {
    val map = NavigationMap()
    val cities = PathParser().parseExtended(input)
    return map.find(cities, Vertex(0,0))
}