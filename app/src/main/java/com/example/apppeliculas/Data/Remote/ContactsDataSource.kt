package com.example.apppeliculas.Data.Remote

import com.example.apppeliculas.Data.Local.contactsapp.ContactsDao
import com.example.apppeliculas.Data.Model.Contacts

class ContactsDataSource(var contacsDao: ContactsDao) {
    suspend fun getContacts():List<Contacts>{
        return contacsDao.getContacts()
    }

    fun addContact(contacts: Contacts) {
        contacsDao.updateContact(contacts)
    }

    fun updateContacts(contacts: Contacts) {
        contacsDao.updateContact(contacts)
    }

}