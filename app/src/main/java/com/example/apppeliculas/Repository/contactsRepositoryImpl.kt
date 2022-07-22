package com.example.apppeliculas.Repository

import androidx.lifecycle.LiveData
import com.example.apppeliculas.Data.Local.contactsapp.ContactsDao
import com.example.apppeliculas.Data.Model.Contacts
import com.example.apppeliculas.Data.Remote.ContactsDataSource

class contactsRepositoryImpl(private val contactsDataSource: ContactsDataSource): contactsRepository{
    override suspend fun addContacts(contacts: Contacts) = contactsDataSource.addContact(contacts)

    override suspend fun updateContacts(contacts: Contacts) = contactsDataSource.updateContacts(contacts)

    override suspend fun getContacts(): List<Contacts> = contactsDataSource.getContacts()
}