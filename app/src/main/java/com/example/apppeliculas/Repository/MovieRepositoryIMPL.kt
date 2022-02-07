package com.example.apppeliculas.Repository

import com.example.apppeliculas.Data.Local.LocalMovieDataSource
import com.example.apppeliculas.Data.Model.MovieListResult
import com.example.apppeliculas.Data.Model.toMovieEntity
import com.example.apppeliculas.Data.Remote.RemoteMovieDataSource

class MovieRepositoryIMPL(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : movieRepository {
    override suspend fun getPlayingNowMovies(): MovieListResult {
        dataSourceRemote.getPlayingNowMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("now_playing"))
        }
        return dataSourceLocal.getPlayingNowMovies()
    }

    override suspend fun getMostPopularMovies(): MovieListResult {
        dataSourceRemote.getMostPopularMovies().results.forEach { movie ->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getMostPopularMovies()
    }
}