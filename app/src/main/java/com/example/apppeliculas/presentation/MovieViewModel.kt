package com.example.apppeliculas.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.apppeliculas.Core.Resource
import com.example.apppeliculas.Repository.movieRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception

class MovieViewModel(private val repo:movieRepository): ViewModel() {
    fun fetchMovies() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Pair(repo.getMostPopularMovies(),repo.getPlayingNowMovies())))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}

class MovieViewModelFactory(private val repo:movieRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(movieRepository::class.java).newInstance(repo)
    }

}