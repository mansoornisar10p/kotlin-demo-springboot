data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

fun main() {
    val p1 = Point(2, 3)
    val p2 = Point(4, 5)
    val sum = p1 + p2
    println("Sum of points: $sum")
}
