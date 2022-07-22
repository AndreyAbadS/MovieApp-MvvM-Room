package com.example.apppeliculas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apppeliculas.R
import com.example.apppeliculas.databinding.FragmentMainBinding


class mainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.btnContacts.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_contactsFragment)
        }
        binding.btnMovies.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_movieFrangment)
        }

    }

}