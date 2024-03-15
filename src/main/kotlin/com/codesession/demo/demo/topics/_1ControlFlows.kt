
fun getBiggerValueRegular (a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun getBiggerValueSimplified (a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun getBiggerValueSimplified2 (a: Int, b: Int): Int {
    //equivalent to a > b ? a : b
    return if (a > b) a else b
}

fun getBiggerValueSimplified3 (a: Int, b: Int): Int = if (a > b) a else b


//----------------------------------------------------------------------------------------------------------------------

fun getBiggerValueWithWhen (a: Int, b: Int)/*: Unit*/ {
    val validNumbers = intArrayOf(20, 30)

    when (a) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
}

