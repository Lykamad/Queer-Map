package com.example.ejemplo_21_11.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int?,
    @ColumnInfo(name = "nombre") var cUserName: String,
    var cUserEmail: String,
    var cUserPhone: String,
    var cUserPhoto: String,
    var cUserCity: String,
    var cEurope:Boolean
    )

@Entity(tableName = "perfil")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    var userId: Int?,
    var profilePhoto: String,
    @ColumnInfo(name = "nombre") var profileName: String,
    var profilePronombres: String,
    var profileDescripcion: String,
    var profileOrientacion: String,
    var profileUbicacion:String
)
