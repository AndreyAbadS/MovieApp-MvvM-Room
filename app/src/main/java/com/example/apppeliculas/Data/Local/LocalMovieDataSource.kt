package com.example.apppeliculas.Data.Local

import com.example.apppeliculas.Data.Model.MovieListResult
import com.example.apppeliculas.Data.Model.MoviesDataEntity
import com.example.apppeliculas.Data.Model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {
    suspend fun getPlayingNowMovies(): MovieListResult {
        return movieDao.getAllMovies().filter {
            it.movie_type == "now_playing"
        }.toMovieList()
    }

    suspend fun getMostPopularMovies(): MovieListResult {
        return movieDao.getAllMovies().filter {
            it.movie_type == "popular"
        }.toMovieList()
    }

    suspend fun saveMovie(movie: MoviesDataEntity) {
        movieDao.saveMovie(movie)
    }
}