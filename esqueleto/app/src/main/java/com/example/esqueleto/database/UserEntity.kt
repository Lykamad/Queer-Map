package com.example.esqueleto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sitios")
data class LocationsEntity(
    @PrimaryKey(autoGenerate = true)
    var placeId: Int?,
    @ColumnInfo(name = "nombre") var placeName: String,
    var placeWeb: String,
    var placePhone: String,
    var placePhoto: String,
    var placeAddress: String
    )
