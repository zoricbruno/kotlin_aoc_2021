package day10.navigation

import java.lang.IllegalStateException
import java.util.*

class Navigator {

    private val opening = "([{<".toSet()
    private val closing = ")]}>".toSet()
    private val errorFreeCode = '-'

    fun calculateErrorPoints(lines: List<String>): Int {
        return lines.map { findError(it) }.sumOf { mapErrorToPoints(it) }
    }

    fun calculateCompletionPoints(lines: List<String>): Long{
        val completionPoints = findCompletingChunks(lines)
            .map { mapCompletingChunkToPoints(it) }
            .sorted()
        return completionPoints[completionPoints.size / 2]
    }

    fun findCompletingChunks(lines: List<String>): List<String>{
        val incompleteLines = lines.filter { findError(it) == errorFreeCode }
        return incompleteLines.map { findCompletingChunk(it) }
    }

    fun findCompletingChunk(line: String): String{
        val pushDownAutomata = LinkedList<Char>()
        for (char in line) {
            if (opening.contains(char)) {
                pushDownAutomata.push(char)
            }
            if (closing.contains(char)) {
                if (pushDownAutomata.peek() == mapClosingToOpening(char)) {
                    pushDownAutomata.pop()
                } else {
                    throw IllegalStateException("This is not an incomplete line - ${line}.")
                }
            }
        }
        return pushDownAutomata.map { mapOpeningToClosing(it) }.joinToString("")
    }

    private fun mapErrorToPoints(code: Char): Int {
        return when (code) {
            ')' -> 3
            ']' -> 57
            '}' -> 1197
            '>' -> 25137
            else -> 0
        }
    }

    private fun mapClosingCharToPoints(code: Char): Int{
        return when (code) {
            ')' -> 1
            ']' -> 2
            '}' -> 3
            '>' -> 4
            else -> 0
        }
    }

     fun mapCompletingChunkToPoints(completingChunk: String): Long{
        var total = 0L
        for (char in completingChunk){
            total *= 5L
            total += mapClosingCharToPoints(char)
        }
        return total
    }

    private fun mapClosingToOpening(code: Char): Char {
        return when (code) {
            ')' -> '('
            ']' -> '['
            '}' -> '{'
            '>' -> '<'
            else -> throw NoSuchElementException()
        }
    }

    private fun mapOpeningToClosing(code: Char): Char {
        return when (code) {
           '(' -> ')'
           '[' -> ']'
           '{' -> '}'
           '<' -> '>'
            else -> throw NoSuchElementException()
        }
    }

    fun findError(line: String): Char {
        val pushDownAutomata = LinkedList<Char>()
        for (char in line) {
            if (opening.contains(char)) {
                pushDownAutomata.push(char)
            }
            if (closing.contains(char)) {
                if (pushDownAutomata.peek() == mapClosingToOpening(char)) {
                    pushDownAutomata.pop()
                } else {
                    return char
                }
            }
        }
        return errorFreeCode
    }
}