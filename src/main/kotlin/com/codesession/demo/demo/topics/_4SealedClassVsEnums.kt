sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val error: String) : Result()
    object Loading: Result()
}

enum class Status {
    SUCCESS,
    ERROR
}

fun main() {
    val result: Result = Result.Success("Data fetched successfully")
    val status: Status = Status.SUCCESS

    println("Result: $result")
    println("Status: $status")
}
