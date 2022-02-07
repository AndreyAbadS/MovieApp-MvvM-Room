package com.example.apppeliculas.Adapters.Concats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apppeliculas.Adapters.MovieAdapter
import com.example.apppeliculas.Core.BaseConcatHollder
import com.example.apppeliculas.databinding.PlayingNowRowBinding

class PlayingNowConcatAdapter(private val moviesAdapter: MovieAdapter):
    RecyclerView.Adapter<BaseConcatHollder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHollder<*> {
        val itemBinding = PlayingNowRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHollder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: PlayingNowRowBinding):
        BaseConcatHollder<MovieAdapter>(binding.root){
        override fun bind(adapter: MovieAdapter) {
            binding.rvPlayingNow.adapter = adapter
        }

    }
}