package day13.foil.parsing

import day13.foil.Fold
import day13.foil.HorizontalFold
import day13.foil.SharpLocation
import day13.foil.VerticalFold

class FoilParser {

    private val foldDelimiter = " "
    private val foldPartsDelimiter = "="
    private val verticalFold = "x"
    private val horizontalFold = "y"
    private val sharpLocationDelimiter = ","

    fun parseFolds(input: List<String>): List<Fold>{
        val folds = mutableListOf<Fold>()
        for (i in input.indices.reversed()){
            if(input[i] == "")
                break
            folds.add(parseFold(input[i]))
        }
        folds.reverse()
        return folds
    }

    private fun parseFold(input: String): Fold {
        val parts = input.split(foldDelimiter).last().split(foldPartsDelimiter)
        val type = parts.first()
        val index = parts.last().toInt()
        return when (type) {
            verticalFold -> VerticalFold(index)
            horizontalFold -> HorizontalFold(index)
            else -> throw IllegalArgumentException("Illegal fold ${input}.")
        }
    }

    fun parseSharpLocations(input: List<String>): List<SharpLocation>{
        val sharpLocations = mutableListOf<SharpLocation>()
        for (i in input.indices){
            if(input[i] == "")
                break
            sharpLocations.add(parseSharpLocation(input[i]))
        }
        return sharpLocations
    }

    private fun parseSharpLocation(input: String): SharpLocation {
        val location = input.split(sharpLocationDelimiter).map { it.toInt() }
        return SharpLocation(location.last(), location.first())
    }
}