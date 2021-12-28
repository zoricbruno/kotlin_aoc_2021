package day17

import day17.probing.Launcher
import day17.probing.TargetArea

fun main() {
    part1()
    part2()
}

fun part1() {
    var target = TargetArea(20, 30, -10, -5)
    val launcher = Launcher()
    var highest = launcher.launchFancyProbe(target)
    println(highest)

    target = TargetArea(29, 73, -248, -194)
    highest = launcher.launchFancyProbe(target)
    println(highest)
}

fun part2() {
    var target = TargetArea(20, 30, -10, -5)
    val launcher = Launcher()
    var possibleShots = launcher.launchSmartProbe(target)
    println(possibleShots)

    target = TargetArea(29, 73, -248, -194)
    possibleShots = launcher.launchSmartProbe(target)
    println(possibleShots)
}

