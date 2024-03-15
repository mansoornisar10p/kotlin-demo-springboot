import java.text.SimpleDateFormat
import java.util.*

fun String.addWelcome(): String {
    return "Welcome, $this"
}

//String Reversal
fun String.reverse(): String {
    return this.reversed()
}

//Date Formatting
fun Date.format(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern)
    return dateFormat.format(this)
}


//Collection Sum Extension
fun List<Int>.sum(): Int {
    var sum = 0
    for (element in this) {
        sum += element
    }
    return sum
}
fun main() {
    val name = "John"
    println(name.addWelcome())
}
