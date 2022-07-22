package com.example.apppeliculas.Data.Local.contactsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apppeliculas.Data.Model.Contacts

@Database(entities = [Contacts::class], version = 1, exportSchema = false)

abstract class ContactsDataBase:RoomDatabase() {
    abstract fun contactsDao():ContactsDao

    companion object{
        @Volatile
        private var instance: ContactsDataBase? = null
        fun getDatabase(context: Context): ContactsDataBase{
            instance = instance ?: Room.databaseBuilder(
                context.applicationContext, ContactsDataBase::class.java, "contacts_table"
            ).build()
            return instance!!
        }
    }
}