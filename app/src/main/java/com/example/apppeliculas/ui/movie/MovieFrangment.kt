package com.example.apppeliculas.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.apppeliculas.Adapters.Concats.PlayingNowConcatAdapter
import com.example.apppeliculas.Adapters.Concats.PopularConcatAdapter
import com.example.apppeliculas.Adapters.MovieAdapter
import com.example.apppeliculas.Core.Resource
import com.example.apppeliculas.Data.Local.AppDataBase
import com.example.apppeliculas.Data.Local.LocalMovieDataSource
import com.example.apppeliculas.Data.Model.MoviesDataJson
import com.example.apppeliculas.Data.Remote.RemoteMovieDataSource
import com.example.apppeliculas.R
import com.example.apppeliculas.Repository.MovieRepositoryIMPL
import com.example.apppeliculas.Repository.Retrofitweb
import com.example.apppeliculas.databinding.FragmentMovieFrangmentBinding
import com.example.apppeliculas.presentation.MovieViewModel
import com.example.apppeliculas.presentation.MovieViewModelFactory


class MovieFrangment : Fragment(R.layout.fragment_movie_frangment),
    MovieAdapter.MovieClickListener {
    //Inyection Dependency
    private lateinit var binding: FragmentMovieFrangmentBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryIMPL(
                RemoteMovieDataSource(Retrofitweb.webservice),
                LocalMovieDataSource(AppDataBase.getDataBase(requireContext()).movieDao())
            )
        )
    }
    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieFrangmentBinding.bind(view)
        concatAdapter = ConcatAdapter()
        //Fetch ALL or NOTHING!
        viewModel.fetchMovies().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    binding.ProgressBar.visibility = View.VISIBLE
                }
                is Resource.Failure -> {
                    binding.ProgressBar.visibility = View.GONE
                    Log.d("LiveDataFailure", "${it.exception}")
                }
                is Resource.Success -> {
                    binding.ProgressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            PopularConcatAdapter(
                                MovieAdapter(
                                    it.data.first.results,
                                    this@MovieFrangment
                                )
                            )
                        )
                        addAdapter(
                            1,
                            PlayingNowConcatAdapter(
                                MovieAdapter(
                                    it.data.second.results,
                                    this@MovieFrangment
                                )
                            )
                        )
                        binding.RvMovies.adapter = concatAdapter
                    }
                    Log.d(
                        "LiveDataSucess",
                        "Popular ${it.data.first}\n \n PlayingNow ${it.data.second}"
                    )
                }
            }
        })
    }

    override fun onMovieClick(movie: MoviesDataJson) {
        val Action = MovieFrangmentDirections.actionMovieFrangmentToMovieDetailFragment(
            movie.poster_path,
            movie.backdrop_path!!,
            movie.vote_average.toFloat(),
            movie.vote_count,
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date,
            movie.popularity.toFloat()
        )
        findNavController().navigate(Action)
        Log.d("Movie", "OnMovieClick:${movie}")
    }
}