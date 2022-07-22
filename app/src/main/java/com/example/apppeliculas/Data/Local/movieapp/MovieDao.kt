package com.example.apppeliculas.Data.Local.movieapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apppeliculas.Data.Model.MoviesDataEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM MoviesDataEntity")
    suspend fun getAllMovies():List<MoviesDataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie:MoviesDataEntity)
}