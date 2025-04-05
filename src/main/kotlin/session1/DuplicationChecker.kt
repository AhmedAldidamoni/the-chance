package session1

import util.printTestResult

fun hasDuplicatesIgnoreSign(numbers: List<Int>): Boolean {
    val seen = mutableListOf<Int>()
    numbers.forEach { currentNumber ->
        val ignoredSignNumber = kotlin.math.abs(currentNumber)
        if (ignoredSignNumber in seen) {
            return true
        }
        seen.add(ignoredSignNumber)
    }
    return false
}

private fun main(){
    hasDuplicatesIgnoreSign(listOf(-1, -2, -7, -3, -4, -2))
        .printTestResult(true,  "when have a list with negative duplicates it should return true")

    hasDuplicatesIgnoreSign(listOf(0, 1, 2, 0))
        .printTestResult(true, "when have a list with zero duplicated it should return true")
}

