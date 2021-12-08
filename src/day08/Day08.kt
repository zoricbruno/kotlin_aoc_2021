package day08

import day08.displays.DigitCounter
import day08.displays.SegmentParser
import day08.displays.SignalToDigitMapper
import readInput

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("08", "Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 61229)

    val input = readInput("08", "Day08")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    val displays = SegmentParser().parse(input)
    val digitCounter = DigitCounter(SignalToDigitMapper())
    return digitCounter.countDigits(displays, listOf(1,4,7,8))
}

fun part2(input: List<String>): Int {
    val displays = SegmentParser().parse(input)
    val digitCounter = DigitCounter(SignalToDigitMapper())
    return digitCounter.sumOutputs(displays)
}

