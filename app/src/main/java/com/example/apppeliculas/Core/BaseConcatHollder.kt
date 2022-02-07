package com.example.apppeliculas.Core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseConcatHollder<T>(itemView:View):RecyclerView.ViewHolder(itemView) {
    //Binder the adapter
    abstract fun bind(adapter:T)
}