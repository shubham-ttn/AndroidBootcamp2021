package com.example.androidbootcamp2021.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidbootcamp2021.PersonDataClass

@Database(entities = [PersonDataClass::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao() : PersonDao
}