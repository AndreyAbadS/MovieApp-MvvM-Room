package com.example.apppeliculas.Data.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apppeliculas.Data.Model.MoviesDataEntity

@Database(entities = [MoviesDataEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            instance = instance ?: Room.databaseBuilder(
                context.applicationContext, AppDataBase::class.java,
                "movie_table"
            ).build()
            return instance!!
        }
    }
}