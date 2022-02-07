package com.example.apppeliculas.Data.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MoviesDataJson(
    val id: Int = -1,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type: String = ""
)

data class MovieListResult(val results: List<MoviesDataJson> = listOf())

//Room
@Entity
data class MoviesDataEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name = "adult")
    val adult: Boolean = false,
    @ColumnInfo(name = "backdrop_path")
    val backdrop_path: String = "",
    @ColumnInfo(name = "original_language")
    val original_language: String = "",
    @ColumnInfo(name = "overview")
    val overview: String = "",
    @ColumnInfo(name = "popularity")
    val popularity: Double = -1.0,
    @ColumnInfo(name = "poster_path")
    val poster_path: String = "",
    @ColumnInfo(name = "release_date")
    val release_date: String = "",
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "video")
    val video: Boolean = false,
    @ColumnInfo(name = "vote_average")
    val vote_average: Double = -1.0,
    @ColumnInfo(name = "vote_count")
    val vote_count: Int = -1,
    @ColumnInfo(name = "movie_type")
    val movie_type: String = ""
)

//Convert List to Other Type the List
fun List<MoviesDataEntity>.toMovieList(): MovieListResult {
    val resultList = mutableListOf<MoviesDataJson>()
    this.forEach { moviesDataEntity ->
        resultList.add(moviesDataEntity.toMovie())
    }
    return MovieListResult(resultList)
}

fun MoviesDataEntity.toMovie(): MoviesDataJson = MoviesDataJson(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    this.movie_type
)

fun MoviesDataJson.toMovieEntity(movieType:String): MoviesDataEntity = MoviesDataEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count,
    movie_type = movieType
)