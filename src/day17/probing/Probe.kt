package day17.probing

class Launcher {
    fun launchFancyProbe(targetArea: TargetArea): Int {

        val highest = mutableListOf<Int>()

        for (x in -1000..1000){
            for (y in -1000..1000){
                val probe = Probe(x,y)
                val trajectory = mutableListOf<Int>()
                while (!targetArea.isOvershot(probe)) {
                    trajectory.add(probe.yPosition)
                    if (targetArea.isInTargetArea(probe)) {
                        highest.add(trajectory.maxOf { it })
                    }
                    probe.moveStep()
                }
            }
        }
        return highest.maxOf { it }
    }

    fun launchSmartProbe(targetArea: TargetArea): Int {

        val possibleShots = mutableSetOf<Pair<Int, Int>>()

        for (x in 0..1000){
            for (y in -1000..1000){
                val probe = Probe(x,y)
                while (!targetArea.isOvershot(probe)) {
                    if (targetArea.isInTargetArea(probe)) {
                        possibleShots.add(Pair(x,y))
                    }
                    probe.moveStep()
                }
            }
        }
        return possibleShots.count()
    }
}

data class Probe(
    var xVelocity: Int,
    var yVelocity: Int,
    var xPosition: Int = 0,
    var yPosition: Int = 0,
) {
    fun moveStep() {
        xPosition += xVelocity
        yPosition += yVelocity
        if (xVelocity < 0) xVelocity++
        else if (xVelocity > 0) xVelocity--
        yVelocity--
    }
}

data class TargetArea(
    private val xLower: Int,
    private val xUpper: Int,
    private val yLower: Int,
    private val yUpper: Int,
) {
    fun isInTargetArea(probe: Probe): Boolean {
        return probe.xPosition in xLower..xUpper &&
                probe.yPosition in yLower..yUpper
    }

    fun isOvershot(probe: Probe): Boolean {
        return probe.xPosition > xUpper || probe.yPosition < yLower
    }
}