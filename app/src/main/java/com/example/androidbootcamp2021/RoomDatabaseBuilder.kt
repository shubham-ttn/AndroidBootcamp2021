package com.example.androidbootcamp2021

import android.content.Context
import androidx.room.Room

object RoomDatabaseBuilder {
    private var INSTANCE: AppRoomDatabase? = null

    fun getInstance(context: Context): AppRoomDatabase {
        if (INSTANCE == null) {
            synchronized(AppRoomDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    // Creating database using Room
    private fun buildRoomDB(context: Context): AppRoomDatabase? {
        return Room.databaseBuilder(context, AppRoomDatabase::class.java, "emp_db")
            .fallbackToDestructiveMigration().build()
    }

}