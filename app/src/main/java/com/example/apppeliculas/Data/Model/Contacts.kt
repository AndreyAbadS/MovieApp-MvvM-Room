package com.example.apppeliculas.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val last_name:String,
    val cellphone:Int,
    val direction:String,
    val email:String,
    val is_favorite:Boolean = false
)