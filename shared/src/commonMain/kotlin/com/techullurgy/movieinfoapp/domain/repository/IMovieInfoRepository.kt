package com.techullurgy.movieinfoapp.domain.repository

import com.techullurgy.movieinfoapp.domain.mappers.toMovie
import com.techullurgy.movieinfoapp.domain.models.Movie
import com.techullurgy.movieinfoapp.domain.utils.NetworkResult
import com.techullurgy.movieinfoapp.domain.utils.ServiceResult
import com.techullurgy.movieinfoapp.usecases.DiscoverMovieUseCase
import com.techullurgy.movieinfoapp.usecases.GetFavouriteMoviesUseCase

interface IMovieInfoRepository {
    suspend fun getFavouriteMovies(page: Int): ServiceResult<List<Movie>>

    suspend fun discoverMovies(page: Int): ServiceResult<List<Movie>>
}

internal class MovieInfoRepositoryImpl(
    private val getFavouriteMoviesUseCase: GetFavouriteMoviesUseCase,
    private val discoverMovieUseCase: DiscoverMovieUseCase
): IMovieInfoRepository {
    override suspend fun getFavouriteMovies(page: Int): ServiceResult<List<Movie>> {
        return when(val result = getFavouriteMoviesUseCase(page)) {
            is NetworkResult.Success -> {
                val moviesList = result.data.map { it.toMovie() }
                ServiceResult(data = moviesList, errorMessage = null)
            }
            is NetworkResult.Failure -> {
                ServiceResult(data = null, errorMessage = result.message)
            }
        }
    }

    override suspend fun discoverMovies(page: Int): ServiceResult<List<Movie>> {
        return when(val result = discoverMovieUseCase(page)) {
            is NetworkResult.Success -> {
                val moviesList = result.data.map { it.toMovie() }
                ServiceResult(data = moviesList, errorMessage = null)
            }
            is NetworkResult.Failure -> {
                ServiceResult(data = null, errorMessage = result.message)
            }
        }
    }
}