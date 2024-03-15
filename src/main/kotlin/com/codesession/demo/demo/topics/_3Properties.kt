class Rectangle(private var width: Int, private var height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height

    var string: String
        get() = this.toString()
        set(value) {
            setDataFromString(value) // parses the string and assigns values to other properties
        }

    private fun setDataFromString(value: String) {
        val it = value.split("x");

        this.width = it[0].toInt()
        this.height = it[1].toInt()
    }
}

fun main() {
    val rectangle = Rectangle(10, 20)
    println(rectangle.area) // 200
    rectangle.string = "30x40"
    println(rectangle.area) // 1200
}