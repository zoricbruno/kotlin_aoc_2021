package day03.diagnostics

class ReportGenerator(
    private val binaryConverter: BinaryConverter = BinaryConverter()
) {

    fun generateReport(codes: List<String>): Report {
        val mostCommon = binaryConverter.findMostCommonBits(codes)
        val gamma = binaryConverter.fromBitStringToInt(mostCommon)

        val leastCommon = binaryConverter.invert(mostCommon)
        val eps = binaryConverter.fromBitStringToInt(leastCommon)

        return Report(gamma, eps)
    }

    fun generateRating(codes: List<String>): Rating {

        val oxygenRatingBitString = binaryConverter.filter(codes, binaryConverter::findMostCommonBit)
        val oxygenRating = binaryConverter.fromBitStringToInt(oxygenRatingBitString)

        val carbonDioxideRatingBitString = binaryConverter.filter(codes, binaryConverter::findLeastCommonBit)
        val carbonDioxideRating = binaryConverter.fromBitStringToInt(carbonDioxideRatingBitString)

        return Rating(oxygenRating, carbonDioxideRating)
    }
}

