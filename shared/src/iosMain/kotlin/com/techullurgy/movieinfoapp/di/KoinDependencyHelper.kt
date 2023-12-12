package com.techullurgy.movieinfoapp.di

import com.techullurgy.movieinfoapp.domain.repository.IMovieInfoRepository
import com.techullurgy.movieinfoapp.domain.repository.Repositories

//import com.techullurgy.movieinfoapp.usecases.GetFavouriteMoviesUseCase
//import org.koin.core.component.KoinComponent
//import org.koin.core.component.inject

//object KoinDependencyHelper: KoinComponent {
//    private val getFavouriteMovies: GetFavouriteMoviesUseCase by inject()
//
//    internal fun provideGetFavouriteMoviesUseCase() = getFavouriteMovies
//}

object KoinDependencyHelper {
    fun getMovieInfoRepository(): IMovieInfoRepository {
        return Repositories.movieInfoRepository
    }
}