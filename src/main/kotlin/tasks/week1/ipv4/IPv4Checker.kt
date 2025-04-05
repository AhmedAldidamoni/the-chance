package tasks.week1.ipv4

fun checkValidIPv4(ip: String): Boolean {
    // Split the string by '.' into segments.
    val parts = ip.split(".")

    // The address must contain exactly four segments.
    if (parts.size != 4) return false

    // Check each segment.
    for (part in parts) {
        // A segment must not be empty.
        if (part.isEmpty()) return false

        // Leading zeros are not allowed unless the segment is exactly "0".
        if (part.length > 1 && part[0] == '0') return false

        // Try converting the segment to an integer.
        try {
            val num = part.toInt()
            // The integer must be in the range 0 to 255.
            if (num !in 0..255) return false
        } catch (e: NumberFormatException) {
            // If conversion fails, the segment is not a valid number.
            return false
        }
    }

    return true
}
