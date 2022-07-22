package com.example.apppeliculas.Data.Local.contactsapp

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apppeliculas.Data.Model.Contacts

@Dao
interface ContactsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contacts: Contacts)

    @Query("SELECT * FROM contacts_table ORDER BY id ASC")
    fun getContacts(): List<Contacts>

    @Update
    fun updateContact(contacts: Contacts)

}