package day12

import day12.mapping.*
import day12.mapping.cave_filtering.NonRepeatingSmallCaveFilter
import day12.mapping.cave_filtering.SingleRepeatableSmallCaveFilter
import day12.mapping.path.PathParser
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("12", "Day12_test")
    check(part1(testInput) == 10)
    check(part2(testInput) == 36)

    val input = readInput("12", "Day12")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val paths = PathParser().parse(input)
    val caveGraph = CaveGraph(NonRepeatingSmallCaveFilter())
    caveGraph.addPaths(paths)
    val routes = caveGraph.getAllRoutes()
    return routes.size
}

fun part2(input: List<String>): Int {
    val paths = PathParser().parse(input)
    val caveGraph = CaveGraph(SingleRepeatableSmallCaveFilter())
    caveGraph.addPaths(paths)
    val routes = caveGraph.getAllRoutes()
    return routes.size
}

