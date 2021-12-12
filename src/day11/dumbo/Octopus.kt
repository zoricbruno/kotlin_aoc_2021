package day11.dumbo

data class Octopus(
    var energy: Int = 0,
    var flashes: Int = 0
){
    fun increaseEnergy(){
        energy++
    }
    fun onDayComplete() {
        if(energy >= 10){
            energy = 0
            flashes +=1
        }
    }
}