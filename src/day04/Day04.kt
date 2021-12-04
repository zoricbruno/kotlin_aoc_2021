package day04

import day04.bingo.BingoInputParser
import day04.bingo.BingoGame
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("04", "Day04_test")

    val part1test = part1(testInput)
    val part2test = part2(testInput)

    println(part1test)
    println(part2test)

    check(part1test == 4512)
    check(part2test == 1924)

    val input = readInput("04", "Day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val parser = BingoInputParser()
    return BingoGame(parser.extractDrawnNumbers(input), parser.extractBingoCards(input))
        .play()
        .first()
        .score}

fun part2(input: List<String>): Int {
    val parser = BingoInputParser()
    return BingoGame(parser.extractDrawnNumbers(input), parser.extractBingoCards(input))
        .play()
        .last()
        .score
}

