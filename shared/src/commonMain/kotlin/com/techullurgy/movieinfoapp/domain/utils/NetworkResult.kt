package com.techullurgy.movieinfoapp.domain.utils

internal sealed class NetworkResult<out T> {
    data class Success<T>(val data: T): NetworkResult<T>()
    data class Failure(val message: String): NetworkResult<Nothing>()
}
