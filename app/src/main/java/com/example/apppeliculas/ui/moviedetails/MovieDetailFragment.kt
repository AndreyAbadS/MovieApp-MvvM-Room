package com.example.apppeliculas.ui.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.apppeliculas.Material.UrlStatic
import com.example.apppeliculas.R
import com.example.apppeliculas.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)
        binding.txtDescription.text = args.description
        binding.txtMovieTitle.text = args.tittle
        binding.txtLenguage.text = "Language ${args.lenguage}"
        binding.txtRaiting.text = "${args.voteAvarage} (${args.voteCount} Reviews)"
        binding.txtRelese.text = "Released ${args.relaseDate}"
        binding.txtPopularity.text = "${args.popularity}"
        Glide.with(requireContext()).load("${UrlStatic.Url_ImageStatic}${args.posterImageUrl}")
            .centerCrop().into(binding.imageMovie)
        Glide.with(requireContext()).load("${UrlStatic.Url_ImageStatic}${args.backImageUrl}")
            .centerCrop().into(binding.imageBackground)

    }
}