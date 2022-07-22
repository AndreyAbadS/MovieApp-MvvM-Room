package com.example.apppeliculas.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.apppeliculas.Core.BaseVH
import com.example.apppeliculas.Data.Model.Contacts
import com.example.apppeliculas.databinding.ContactItemBinding

class ContactsAdapter(private val contactsList: List<Contacts>,
private val itemClicListener: onContactsClickListener):RecyclerView.Adapter<BaseVH<*>>() {

    interface onContactsClickListener{
        fun onContactsClick(contacts: Contacts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH<*> {
        val itemBinding = ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val holder = ContactsViewHolder(itemBinding,parent.context)
        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION } ?: return@setOnClickListener
            itemClicListener.onContactsClick(contactsList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseVH<*>, position: Int) {
        when(holder){
            is ContactsViewHolder -> holder.bind(contactsList[position])
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ContactsViewHolder(val binding: ContactItemBinding,val context: Context): BaseVH<Contacts>(binding.root) {
        override fun bind(item: Contacts) {
            binding.tvName.text = item.name
            binding.tvLastName.text = item.name
        }
    }
}