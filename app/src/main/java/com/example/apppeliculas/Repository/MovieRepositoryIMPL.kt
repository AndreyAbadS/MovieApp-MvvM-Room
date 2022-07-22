package com.example.apppeliculas.Repository

import com.example.apppeliculas.Core.internetCheck
import com.example.apppeliculas.Data.Local.movieapp.LocalMovieDataSource
import com.example.apppeliculas.Data.Model.MovieListResult
import com.example.apppeliculas.Data.Model.toMovieEntity
import com.example.apppeliculas.Data.Remote.RemoteMovieDataSource

class MovieRepositoryIMPL(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : movieRepository {
    override suspend fun getPlayingNowMovies(): MovieListResult {
        //Check Conection
        return if (internetCheck.networkConectionOn()) {
            dataSourceRemote.getPlayingNowMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("now_playing"))
            }
            dataSourceLocal.getPlayingNowMovies()
        } else {
            dataSourceLocal.getPlayingNowMovies()
        }
    }

    override suspend fun getMostPopularMovies(): MovieListResult {
        //Check Conection
        return if (internetCheck.networkConectionOn()){
            dataSourceRemote.getMostPopularMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
            }
            return dataSourceLocal.getMostPopularMovies()
        }else{
            return dataSourceLocal.getMostPopularMovies()
        }

    }
}