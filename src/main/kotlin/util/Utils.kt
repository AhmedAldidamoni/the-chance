package util

fun Boolean.printTestResult(correctResult: Boolean, description:String) =
    if (this == correctResult) println("Success - $description")
    else println("Failed- $description")

