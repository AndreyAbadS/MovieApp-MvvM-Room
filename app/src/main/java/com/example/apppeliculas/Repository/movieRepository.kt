package com.example.apppeliculas.Repository

import com.example.apppeliculas.Data.Model.MovieListResult

interface movieRepository {
    suspend fun getPlayingNowMovies(): MovieListResult
    suspend fun getMostPopularMovies(): MovieListResult
}