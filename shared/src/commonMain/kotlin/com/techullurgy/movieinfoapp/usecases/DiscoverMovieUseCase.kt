package com.techullurgy.movieinfoapp.usecases

import com.techullurgy.movieinfoapp.data.network.Endpoint
import com.techullurgy.movieinfoapp.data.network.models.DiscoverMovieResponse
import com.techullurgy.movieinfoapp.data.network.models.DiscoveredMovie
import com.techullurgy.movieinfoapp.domain.utils.NetworkResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

internal class DiscoverMovieUseCase(
    private val httpClient: HttpClient
) {
    suspend operator fun invoke(page: Int): NetworkResult<List<DiscoveredMovie>> {
        return try {
            val discoverMovieResponse = httpClient
                .get(Endpoint.discoverMoviesEndpointFor(page)) {
                    header("accept", "application/json")
                    header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMzQwOTQzOTQzNTZjNTQxMWIwMTA1ZGQzMTBmNzcwZiIsInN1YiI6IjY1NDc0MGM2ZDU1YzNkMDExY2NmYmRlNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.HCYGZaWsA9uNY62ZXLYhdGnjTEot9hmk8TD3CP1AaP8")
                }
                .body<DiscoverMovieResponse>()
            println(discoverMovieResponse)
            NetworkResult.Success(discoverMovieResponse.discoveredMovies)
        } catch (e: Exception) {
            NetworkResult.Failure(e.message!!)
        }
    }
}