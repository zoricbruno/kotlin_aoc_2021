package day04.bingo

class BingoGame(
    private var drawnNumbers: DrawnNumbers,
    private var cards: List<BingoCard>
) {

    fun play(): List<Winner> {
        val currentDraw = mutableListOf<Int>()
        val winnerIndices = mutableListOf<Int>()
        val winners = mutableListOf<Winner>()
        for (number in drawnNumbers.numbers){
            currentDraw.add(number)
            for ((index, card) in cards.withIndex()){
                if(!winnerIndices.contains(index)){
                    if(card.isWinner(currentDraw)){
                        val score = card.getAllNonGuessedNumbers(currentDraw).sum() * number
                        winnerIndices.add(index)
                        winners.add(Winner(card, score))
                    }
                }
            }
        }
        return winners
    }
}

class Winner(
    val card: BingoCard,
    val score: Int,
)