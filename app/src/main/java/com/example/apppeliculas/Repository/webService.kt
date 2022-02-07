package com.example.apppeliculas.Repository

import com.example.apppeliculas.Data.Model.MovieListResult
import com.example.apppeliculas.Material.UrlStatic
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface webService {
    @GET("movie/now_playing")
    suspend fun getPlayingNowMovies(@Query("api_key")apiKey:String): MovieListResult
    @GET("movie/popular")
    suspend fun getMostPopularMovies(@Query("api_key")apiKey:String): MovieListResult
}

object Retrofitweb{
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(UrlStatic.Url_static)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(webService::class.java)
    }
}