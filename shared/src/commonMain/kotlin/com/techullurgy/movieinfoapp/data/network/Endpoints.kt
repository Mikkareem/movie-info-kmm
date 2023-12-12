package com.techullurgy.movieinfoapp.data.network

internal sealed class Endpoint(private val endpoint: String) {
    private class GetFavouriteMoviesRoute(
        page: Int,
        language: String = "en-US",
        sortBy: String = "created_at.asc"
    ): Endpoint("favorite/movies?language=$language&page=$page&sort_by=$sortBy")

    private class DiscoverMoviesRoute(
        page: Int,
        language: String = "en-US",
        sortBy: String = "popularity.desc"
    ): Endpoint("discover/movie?language=$language&page=$page&sort_by=$sortBy")

    fun getPath(isAccountAdded: Boolean = false): String {
        val basePath = if(isAccountAdded) "$BASE_URL/account/20667503" else BASE_URL
        return "$basePath/$endpoint"
    }

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3"
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

        fun getImagePath(posterImage: String): String = "$IMAGE_BASE_URL$posterImage"

        fun getFavouriteMoviesEndpointFor(page: Int): String = GetFavouriteMoviesRoute(page = page).getPath(true)
        fun discoverMoviesEndpointFor(page: Int): String = DiscoverMoviesRoute(page = page).getPath()
    }
}