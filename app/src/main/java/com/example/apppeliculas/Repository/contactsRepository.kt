package com.example.apppeliculas.Repository

import com.example.apppeliculas.Data.Model.Contacts

interface contactsRepository {
    suspend fun getContacts(): List<Contacts>
    suspend fun addContacts(contacts: Contacts)
    suspend fun updateContacts(contacts: Contacts)
}