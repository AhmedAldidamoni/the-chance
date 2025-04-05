package tasks.week1.ipv4

import util.printTestResult

private fun main() {
    println("Valid cases:")
    testValidCases()

    println("\nInvalid cases:")
    testInvalidCases()
}

private fun testValidCases() {
    checkValidIPv4("192.168.1.1").printTestResult(true, "Valid IPv4 address")
    checkValidIPv4("255.255.255.255").printTestResult(true, "Valid IPv4 address (MAX)")
    checkValidIPv4("0.0.0.0").printTestResult(true, "Valid IPv4 address (MIN)")
}

private fun testInvalidCases() {
    checkValidIPv4("256.100.50.0").printTestResult(false, "Segment exceeds 255")
    checkValidIPv4("192.168.01.1").printTestResult(false, "Leading zero not allowed")
    checkValidIPv4("192.168.1.").printTestResult(false, "Incomplete address - missing segment")
    checkValidIPv4("192.168.1.1.1").printTestResult(false, "Extra segment")
    checkValidIPv4("192.168.1.a").printTestResult(false, "Non-numeric segment")
    checkValidIPv4("192.168.1.-1").printTestResult(false, "Negative number segment")
}
