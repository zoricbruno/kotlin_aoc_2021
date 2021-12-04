package day04.bingo

data class BingoCard(val numbers: List<List<Int>>) {

    private val rows: MutableList<Set<Int>> = mutableListOf()
    private val columns: MutableList<Set<Int>> = mutableListOf()

    init {
        for (i in numbers.indices) {
            val row = mutableSetOf<Int>()
            for (j in numbers.first().indices) {
                row.add(numbers[i][j])
            }
            rows.add(row)
        }
        for (i in numbers.first().indices) {
            val column = mutableSetOf<Int>()
            for (j in numbers.indices) {
                column.add(numbers[j][i])
            }
            columns.add(column)
        }
    }

    fun isWinner(numbers: List<Int>): Boolean {
        val drawnNumbers = numbers.toSet()
        if (rows.any { drawnNumbers.containsAll(it) }) return true
        if (columns.any { drawnNumbers.containsAll(it) }) return true
        return false
    }

    fun getAllNonGuessedNumbers(numbers: List<Int>): List<Int>{
        val availableNumbers = mutableListOf<Int>()
        rows.forEach{availableNumbers.addAll(it)}
        return availableNumbers.minus(numbers.toSet())
    }
}