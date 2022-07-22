package com.example.apppeliculas.ui.contacts

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.apppeliculas.Data.Local.contactsapp.ContactsDao
import com.example.apppeliculas.Data.Remote.ContactsDataSource
import com.example.apppeliculas.R
import com.example.apppeliculas.Repository.contactsRepositoryImpl
import com.example.apppeliculas.databinding.FragmentAddContactsBinding
import com.example.apppeliculas.presentation.ContactsViewModel

class BlankFragment : Fragment(R.layout.fragment_add_contacts) {
    private lateinit var binding: FragmentAddContactsBinding
    private val viewModel by  viewModels<ContactsViewModel> {
        ContactsViewModel.ContactsViewModelFactory(contactsRepositoryImpl(ContactsDataSource()))
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddContactsBinding.bind(view)

    }

    fun checkData(){
        if (binding.etNameContact.text.toString().isEmpty()) {
            binding.etNameContact.error = "Porfavor introduce un nombre"
            binding.etNameContact.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.etEmailAddress.text.toString()).matches()) {
            binding.etEmailAddress.error = "Porfavor introduce un correo electronico valido"
            binding.etEmailAddress.requestFocus()
            return
        }
        if (binding.etLastNameContact.text.toString().isEmpty()) {
            binding.etLastNameContact.error = "Porfavor introduce un apellido"
            binding.etLastNameContact.requestFocus()
            return
        }
        if (binding.etPhone.text.toString().isEmpty()) {
            binding.etLastNameContact.error = "Porfavor introduce un numero de telefono"
            binding.etLastNameContact.requestFocus()
            return
        }
        if (binding.etAddress.text.toString().isEmpty()) {
            binding.etAddress.error = "Porfavor introduce una direccion"
            binding.etAddress.requestFocus()
            return
        }
        fun saveContacts(){

        }
    }

}