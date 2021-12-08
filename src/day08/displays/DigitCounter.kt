package day08.displays

class DigitCounter(
    private val signalToDigitMapper: SignalToDigitMapper
) {
    fun countDigits(displays: List<Display>, digits: List<Int>): Int {
        var totalDigits = 0
        for (display in displays) {
            signalToDigitMapper.createMapping(display.signalPatterns)
            for (digit in display.digits) {
                if (digits.contains(signalToDigitMapper.map(digit)))
                    totalDigits++
            }
        }
        return totalDigits
    }

    fun sumOutputs(displays: List<Display>): Int{
        var total = 0;
        for (display in displays){
            signalToDigitMapper.createMapping(display.signalPatterns)
            total += display.digits.map { signalToDigitMapper.map(it) }.joinToString ("" ).toInt()
        }
        return total
    }
}