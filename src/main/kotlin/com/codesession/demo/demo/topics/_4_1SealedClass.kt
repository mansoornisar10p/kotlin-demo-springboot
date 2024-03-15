import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

sealed class ApiResponse

data class SuccessResponse(val data: Any) : ApiResponse()

data class ErrorResponse(val message: String) : ApiResponse()

@RestController
class ApiController {

    @GetMapping("/api/data")
    fun fetchData(): ApiResponse {
        // Simulating some data retrieval logic
        val data = retrieveDataFromService()

        return if (data != null) {
            SuccessResponse(data)
        } else {
            ErrorResponse("Failed to retrieve data")
        }
    }

    private fun retrieveDataFromService(): Any? {
        // Simulate data retrieval logic
        return ""// Some data or null
    }
}
