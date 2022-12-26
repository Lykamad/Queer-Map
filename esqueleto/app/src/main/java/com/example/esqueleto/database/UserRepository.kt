package com.example.esqueleto.database

import androidx.lifecycle.LiveData

class UserRepository (private val userDatabaseDao: UserDAO) {

    val readAllData: LiveData<List<LocationsEntity>> = userDatabaseDao.getAll()

    suspend fun addListLocation(locationItem: List<LocationsEntity>){
        userDatabaseDao.insert(locationItem)
    }

    suspend fun addLocation(locationItem: LocationsEntity){
        userDatabaseDao.insertElement(locationItem)
    }

    suspend fun updateLocation(locationItem: LocationsEntity){
        userDatabaseDao.update(locationItem)
    }

    suspend fun deleteLocation(locationItem: LocationsEntity){
        userDatabaseDao.delete(locationItem)
    }

    suspend fun deleteAllLocations(){
        userDatabaseDao.deleteAll()
    }
}