interface Printer {
    fun print()
}

class LaserPrinter(private val toner: Toner) : Printer by toner {
    fun printDocument() {
        println("Printing document...")
        print() // This calls the 'print' function of the 'toner' object
    }
}

class Toner : Printer {
    override fun print() {
        println("Printing with toner...")
    }
}

fun main() {
    val toner = Toner()
    val laserPrinter = LaserPrinter(toner)
    laserPrinter.printDocument()
}
