package com.example.apppeliculas.Adapters.Concats

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apppeliculas.Adapters.ContactsAdapter
import com.example.apppeliculas.Core.BaseConcatHollder
import com.example.apppeliculas.databinding.ContactsRowBinding

class ContactsConcatAdapter(private val contactsAdapter: ContactsAdapter):RecyclerView.Adapter<BaseConcatHollder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHollder<*> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseConcatHollder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(contactsAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: ContactsRowBinding): BaseConcatHollder<ContactsAdapter>(binding.root){
        override fun bind(adapter: ContactsAdapter) {
            binding.rvContacts.adapter = adapter
        }

    }
}