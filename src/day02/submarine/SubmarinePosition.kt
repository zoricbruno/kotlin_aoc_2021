package day02.submarine

import day02.submarine.movement.DownMovement
import day02.submarine.movement.ForwardMovement
import day02.submarine.movement.NoMovement
import day02.submarine.movement.UpMovement

open class SubmarinePosition(
    protected var horizontal: Int = 0,
    protected var depth: Int = 0,
) {
    val total: Int
        get() = horizontal * depth

    open fun move(movement: ForwardMovement) {
        horizontal += movement.amount
    }

    open fun move(movement: UpMovement) {
        depth -= movement.amount
    }

    open fun move(movement: DownMovement) {
        depth += movement.amount
    }

    fun move(noMovement: NoMovement) {}
}

