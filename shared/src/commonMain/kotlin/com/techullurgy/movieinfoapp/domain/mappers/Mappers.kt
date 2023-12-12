package com.techullurgy.movieinfoapp.domain.mappers

import com.techullurgy.movieinfoapp.data.network.Endpoint
import com.techullurgy.movieinfoapp.data.network.models.DiscoveredMovie
import com.techullurgy.movieinfoapp.data.network.models.FavouriteMovie
import com.techullurgy.movieinfoapp.domain.models.Movie

internal fun FavouriteMovie.toMovie(): Movie = Movie(
    id = id,
    title = title,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    imageUrl = Endpoint.getImagePath(posterPath),
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
    adult = adult
)

internal fun DiscoveredMovie.toMovie(): Movie = Movie(
    id = id,
    title = title,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    imageUrl = Endpoint.getImagePath(posterPath),
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
    adult = adult
)