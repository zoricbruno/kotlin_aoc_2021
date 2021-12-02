package day02.submarine

import day02.submarine.movement.*

class SubmarineNavigator {

    fun navigate(input: String, position: SubmarinePosition) {
        val inputParts = input.split(' ')
        val movementType = inputParts[0]
        val movementAmount = inputParts[1].toInt()

        when(movementType){
            "forward" -> position.move(ForwardMovement(movementAmount))
            "down" -> position.move(DownMovement(movementAmount))
            "up" -> position.move(UpMovement(movementAmount))
            else -> position.move(NoMovement())
        }
    }
}