package com.example.apppeliculas.presentation

import androidx.lifecycle.*
import com.example.apppeliculas.Core.Resource
import com.example.apppeliculas.Data.Model.Contacts
import com.example.apppeliculas.Repository.contactsRepository
import com.example.apppeliculas.Repository.contactsRepositoryImpl
import kotlinx.coroutines.Dispatchers

class ContactsViewModel(private val repo:contactsRepository):ViewModel() {

    fun addContacts(contacts: Contacts) = liveData(viewModelScope.coroutineContext + Dispatchers.IO){
        try{
            emit(Resource.Success(repo.addContacts(contacts)))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
    fun loadContacts() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.getContacts()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
    fun updateContacts(contacts: Contacts) = liveData(viewModelScope.coroutineContext + Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.updateContacts(contacts)))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
    class ContactsViewModelFactory(private val repo:contactsRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(contactsRepository::class.java).newInstance(repo)
        }
    }
}