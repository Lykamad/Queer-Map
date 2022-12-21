package com.example.esqueleto.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {
    @Query("SELECT * FROM usuarios")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM usuarios WHERE userId= :id")
    fun getById(id: Int):UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: List<UserEntity>) //funciones en segundo plano

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElement (item: UserEntity)

    @Update
    suspend fun update(item: UserEntity)

    @Delete
    suspend fun delete(item: UserEntity)

    @Query ("DELETE FROM usuarios") //@Query no Delete
    suspend fun deleteAll()
}