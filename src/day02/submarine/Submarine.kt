package day02.submarine

class Submarine(
    private val navigator: SubmarineNavigator = SubmarineNavigator(),
    private val position: SubmarinePosition = SubmarinePosition()
) {
    fun getTotalPosition() = position.total
    fun move(command: String) = navigator.navigate(command, position)
}

