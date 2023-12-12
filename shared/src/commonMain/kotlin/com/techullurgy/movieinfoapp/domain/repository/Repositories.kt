package com.techullurgy.movieinfoapp.domain.repository

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object Repositories: KoinComponent {
    val movieInfoRepository: IMovieInfoRepository by inject()
}