package day06.fish.parsing

import day06.fish.LanternFish

class FishInputParser {
    private val fishSeparator: Char = ','

    fun parse(input: String): LanternFish{
        return LanternFish(input.toInt())
    }

    fun parseMultiple(input: String): List<LanternFish>{
        return input.split(fishSeparator).map { parse(it) }
    }
}