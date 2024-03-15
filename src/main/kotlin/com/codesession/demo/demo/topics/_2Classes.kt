
open class Person (val name: String) {

    init {
        println("Init block")
    }

    constructor(name: String, age: Int) : this(name) {
        println("Secondary constructor")
    }

    constructor() : this("default name") {
        println("Secondary constructor")
    }

    private fun sayHello() {
        println("Hello, $name")
    }

    companion object {
        fun createPerson(name: String): Person {
            val person = Person(name)
            person.sayHello() //private function can be called from the companion object
            return person
        }
    }
}


fun main() {
    val person = Person.createPerson("John")
    println(person.name)
}
