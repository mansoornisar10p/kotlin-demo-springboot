fun structuralEquality() {
    val a: Int = 5
    val b: Int = 5
    val c: Int? = 5
    println(a == b) // true
    println(a == c) // true
}


fun referentialEquality() {
    val x = Integer(10)
    val y = Integer(10)
    val z = x
    println(x === y) // false
    println(x === z) // true

}

fun main() {
    val person1 = Person("Alice", 30)
    val person2 = Person("Alice", 30)

    println("person1 == person2: ${person1 == person2}") // Prints true
}

