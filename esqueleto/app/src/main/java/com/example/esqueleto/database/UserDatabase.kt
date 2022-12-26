package com.example.esqueleto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [LocationsEntity:: class], version=1, exportSchema = false) //NO EXAMEN ""
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object{
        private var INSTANCE: UserDatabase?= null
        fun getInstance (context: Context): UserDatabase{
            kotlin.synchronized(this){

                var instance =  INSTANCE

                if (instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}