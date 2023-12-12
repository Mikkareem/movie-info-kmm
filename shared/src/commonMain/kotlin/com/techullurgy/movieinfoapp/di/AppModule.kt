package com.techullurgy.movieinfoapp.di

import com.techullurgy.movieinfoapp.data.network.provideHttpClient
import com.techullurgy.movieinfoapp.domain.repository.IMovieInfoRepository
import com.techullurgy.movieinfoapp.domain.repository.MovieInfoRepositoryImpl
import com.techullurgy.movieinfoapp.usecases.DiscoverMovieUseCase
import com.techullurgy.movieinfoapp.usecases.GetFavouriteMoviesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun appModule() = module {
    single { GetFavouriteMoviesUseCase(get()) }
    single { DiscoverMovieUseCase(get()) }

    singleOf(::MovieInfoRepositoryImpl) bind IMovieInfoRepository::class

    single {
        provideHttpClient()
    }
}