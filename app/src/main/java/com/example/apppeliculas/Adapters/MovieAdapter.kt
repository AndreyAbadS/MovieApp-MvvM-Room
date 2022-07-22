package com.example.apppeliculas.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppeliculas.Core.BaseVH
import com.example.apppeliculas.Data.Model.MoviesDataJson
import com.example.apppeliculas.Material.UrlStatic
import com.example.apppeliculas.databinding.MovieItemBinding

class MovieAdapter(
    private val movieList: List<MoviesDataJson>,
    private val itemClickListener: MovieClickListener
) : RecyclerView.Adapter<BaseVH<*>>() {
    interface MovieClickListener {
        fun onMovieClick(movie: MoviesDataJson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val Position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?: return@setOnClickListener
            itemClickListener.onMovieClick(movieList[Position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseVH<*>, position: Int) {
        when(holder){
            is MoviesViewHolder -> holder.bind(movieList[position])
        }
    }

    override fun getItemCount(): Int = movieList.size

    private inner class MoviesViewHolder(val binding: MovieItemBinding, val context: Context) :
        BaseVH<MoviesDataJson>(binding.root) {
        override fun bind(item: MoviesDataJson) {
            Glide.with(context).load("${UrlStatic.Url_ImageStatic}/${item.poster_path}")
                .centerCrop().into(binding.imageMovie)
        }
    }

}