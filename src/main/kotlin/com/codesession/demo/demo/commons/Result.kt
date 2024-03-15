package com.codesession.demo.demo.commons

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val message: String) : Result<T>()

    companion object {
        @JvmStatic
        fun <T> success(data: T): Result<T> {
            return Success(data)
        }

        @JvmStatic
        fun <T> error(message: String): Result<T> {
            return Error(message)
        }
    }
}
