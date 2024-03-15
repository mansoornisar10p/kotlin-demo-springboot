import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

fun main() {
    var nullableString: String? = "Hello"
    // nullableString = null // Uncommenting this line will result in a compilation error

    println("Length of string: ${nullableString?.length}")
}



/**Null Saftey - Example 2*/

@RestController
class ExampleController {

    data class User(val name: String, val email: String?)

    fun getUser(id: Int): User? {
        return if (id == 1) User("John Doe", null) else null
    }

    @GetMapping("/user/{id}")
    fun getUserDetails(id: Int): String {
        val user = getUser(id)

        // Safe call operator to safely access nullable property
        val emailLength = user?.email?.length ?: 0

        return "User: ${user?.name}, Email Length: $emailLength"
    }
}

