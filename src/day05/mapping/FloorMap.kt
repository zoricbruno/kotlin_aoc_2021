package day05.mapping

import day05.mapping.lines.Line

class FloorMap {
    private val ventOverload = 2
    private val lines = mutableListOf<Line>()

    fun add(line: Line) {
        lines.add(line)
    }

    fun countDangerous(): Int {
        return lines.asSequence()
            .map { it.getAllPoints() }
            .flatten()
            .groupBy { it }
            .map { it.value.size }
            .count { it >= ventOverload }
    }
}

