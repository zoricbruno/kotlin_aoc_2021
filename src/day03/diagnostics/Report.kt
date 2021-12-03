package day03.diagnostics

data class Report(
    val gamma: Int = 0,
    val eps: Int = 0
){
    fun calculatePowerConsumption(): Int = gamma * eps
}

