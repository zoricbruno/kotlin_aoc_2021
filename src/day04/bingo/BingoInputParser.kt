package day04.bingo

class BingoInputParser {

    private val rowsDrawnNumbers = 1
    private val rowsCard = 5
    private val drawnNumbersSeparator = ','
    private val cardNumbersSeparator = ' '
    private val spaceReplaceRegex = "\\s+".toRegex()

    fun extractDrawnNumbers(input: List<String>): DrawnNumbers {
        val numbers = rowToNumbers(input.first(), drawnNumbersSeparator)
        return DrawnNumbers(numbers)
    }

    fun extractBingoCards(input: List<String>): List<BingoCard> {
        val bingoCards = mutableListOf<BingoCard>()
        val cardInputs = input
            .drop(rowsDrawnNumbers)
            .filter { it.isNotEmpty() }
            .chunked(rowsCard)

        cardInputs.forEach { bingoCards.add(extractBingoCardFrom(it)) }
        return bingoCards
    }

    private fun extractBingoCardFrom(cardInput: List<String>): BingoCard{
        val card = BingoCard(cardInput.map {
            rowToNumbers(
                it.trim().replace(spaceReplaceRegex, cardNumbersSeparator.toString()),
                cardNumbersSeparator
            )
        })
        return card
    }

    private fun rowToNumbers(row: String, splitCharacter: Char): List<Int> {
        return row.split(splitCharacter).map { it.toInt() }
    }
}

