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
    @Query("SELECT * FROM sitios")
    fun getAll(): LiveData<List<LocationsEntity>>

    @Query("SELECT * FROM sitios WHERE placeId= :id")
    fun getById(id: Int):LocationsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: List<LocationsEntity>) //funciones en segundo plano

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElement (item: LocationsEntity)

    @Update
    suspend fun update(item: LocationsEntity)

    @Delete
    suspend fun delete(item: LocationsEntity)

    @Query ("DELETE FROM sitios") //@Query no Delete
    suspend fun deleteAll()
}