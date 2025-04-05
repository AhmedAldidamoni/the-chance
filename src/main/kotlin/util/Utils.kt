package util

val <T> List<List<T>>.dimensions get() = Pair(size, firstOrNull()?.size ?: 0)

fun <T> List<List<T>>.isGrid() = isNotEmpty() && all { it.size == firstOrNull()?.size }

fun <T> List<List<T>>.isSquareGrid() = isGrid() && dimensions.first == dimensions.second

fun Boolean.printTestResult(correctResult: Boolean, description:String) =
    if (this == correctResult) println("Success - $description")
    else println("Failed- $description")

