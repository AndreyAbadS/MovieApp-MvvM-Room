package com.example.apppeliculas.Data.Remote

import com.example.apppeliculas.Data.Model.MovieListResult
import com.example.apppeliculas.Material.UrlStatic
import com.example.apppeliculas.Repository.webService

class RemoteMovieDataSource(private val webService: webService) {
    suspend fun getPlayingNowMovies(): MovieListResult =
        webService.getPlayingNowMovies(UrlStatic.Api_Key)

    suspend fun getMostPopularMovies(): MovieListResult =
        webService.getMostPopularMovies(UrlStatic.Api_Key)
}