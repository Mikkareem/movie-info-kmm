package com.techullurgy.movieinfoapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.techullurgy.movieinfoapp.android.presentation.viewmodels.DiscoverMovieViewModel
import com.techullurgy.movieinfoapp.android.presentation.viewmodels.FavouriteMoviesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
//                val viewModel by viewModels<FavouriteMoviesViewModel>()
//                FavouriteMoviesScreen(viewModel = viewModel)

                val viewModel by viewModels<DiscoverMovieViewModel>()
                DiscoverMoviesScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun FavouriteMoviesScreen(
    viewModel: FavouriteMoviesViewModel
) {
    val screenState by viewModel.screenState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val favouriteMovies = screenState.favouriteMovies
    val errorMessage = screenState.errorMessage

    Box(modifier = Modifier.fillMaxSize()) {
        if(isLoading) {
            CircularProgressIndicator()
        } else {
            if(errorMessage.isNotBlank()) {
                Text(text = errorMessage, modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn {
                    items(favouriteMovies) {
                        Text(text = it.title)
                    }
                }
            }
        }
    }
}

@Composable
fun DiscoverMoviesScreen(
    viewModel: DiscoverMovieViewModel
) {
    val screenState by viewModel.screenState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    val favouriteMovies = screenState.discoveredMovies
    val errorMessage = screenState.errorMessage

    Box(modifier = Modifier.fillMaxSize()) {
        if(isLoading) {
            CircularProgressIndicator()
        } else {
            if(errorMessage.isNotBlank()) {
                Text(text = errorMessage, modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn {
                    items(favouriteMovies) {
                        Text(text = it.title)
                    }
                }
            }
        }
    }
}