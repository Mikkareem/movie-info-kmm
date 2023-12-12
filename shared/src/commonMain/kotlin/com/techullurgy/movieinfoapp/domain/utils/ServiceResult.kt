package com.techullurgy.movieinfoapp.domain.utils

data class ServiceResult<T>(
    val data: T?,
    val errorMessage: String? = null
)
