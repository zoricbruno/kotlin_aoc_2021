package day02.submarine

import day02.submarine.movement.DownMovement
import day02.submarine.movement.ForwardMovement
import day02.submarine.movement.UpMovement

open class WeaponizedSubmarinePosition(
    horizontal: Int = 0,
    depth: Int = 0,
    private var aim: Int = 0
) : SubmarinePosition(horizontal, depth){

    override fun move(movement: ForwardMovement) {
        horizontal += movement.amount
        depth += movement.amount * aim
    }

    override fun move(movement: UpMovement) {
        aim -= movement.amount
    }

    override fun move(movement: DownMovement) {
        aim += movement.amount
    }
}