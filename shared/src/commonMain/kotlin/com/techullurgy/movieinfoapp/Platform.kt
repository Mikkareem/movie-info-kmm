package com.techullurgy.movieinfoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform