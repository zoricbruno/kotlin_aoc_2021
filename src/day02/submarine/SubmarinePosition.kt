package day02.submarine

import day02.submarine.movement.DownMovement
import day02.submarine.movement.ForwardMovement
import day02.submarine.movement.NoMovement
import day02.submarine.movement.UpMovement

class SubmarinePosition(
    private var horizontal: Int = 0,
    private var depth: Int = 0
) {
    val total: Int
        get() = horizontal * depth

    fun move(movement: ForwardMovement) {
        horizontal += movement.amount
    }

    fun move(movement: UpMovement) {
        depth -= movement.amount
    }

    fun move(movement: DownMovement) {
        depth += movement.amount
    }

    fun move(noMovement: NoMovement) {}
}