package com.techullurgy.movieinfoapp.domain.models

data class Movie(
    val adult: Boolean,
    val id: Long,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Float,
    val imageUrl: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Float,
    val voteCount: Long
)