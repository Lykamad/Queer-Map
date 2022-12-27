package com.example.ejemplo_21_11.database

import androidx.lifecycle.LiveData

class UserRepository (private val userDatabaseDao: UserDAO) {

    val readAllData: LiveData<List<UserEntity>> = userDatabaseDao.getAll()

    suspend fun addListUser(userItem: List<UserEntity>){
        userDatabaseDao.insert(userItem)
    }

    suspend fun addUser(userItem: UserEntity){
        userDatabaseDao.insertElement(userItem)
    }

    suspend fun updateUser(userItem: UserEntity){
        userDatabaseDao.update(userItem)
    }

    suspend fun deleteUser(userItem: UserEntity){
        userDatabaseDao.delete(userItem)
    }

    suspend fun deleteAllUsers(){
        userDatabaseDao.deleteAll()
    }
}