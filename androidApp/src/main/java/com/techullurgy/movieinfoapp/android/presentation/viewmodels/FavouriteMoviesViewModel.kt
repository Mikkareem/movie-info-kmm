package com.techullurgy.movieinfoapp.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techullurgy.movieinfoapp.domain.models.Movie
import com.techullurgy.movieinfoapp.domain.repository.Repositories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavouriteMoviesViewModel: ViewModel() {
    private val _screenState = MutableStateFlow(FavouriteMoviesScreenState())
    val screenState: StateFlow<FavouriteMoviesScreenState> get() = _screenState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading.asStateFlow()

    init {
        _isLoading.update { true }
        viewModelScope.launch {
            val result = Repositories.movieInfoRepository.getFavouriteMovies(1)
            println(result)
            result.data?.let { movies ->
                println(movies)
                _screenState.update {
                    it.copy(
                        favouriteMovies = movies,
                        errorMessage = ""
                    )
                }
            } ?: result.errorMessage?.let { error ->
                println(error)
                _screenState.update {
                    it.copy(
                        favouriteMovies = emptyList(),
                        errorMessage = error
                    )
                }
            }

            _isLoading.update { false }
        }
    }
}

data class FavouriteMoviesScreenState(
    val favouriteMovies: List<Movie> = emptyList(),
    val errorMessage: String = ""
)