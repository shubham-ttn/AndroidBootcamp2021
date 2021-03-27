package com.example.androidbootcamp2021.database

import android.content.Context
import androidx.room.Room
import com.example.androidbootcamp2021.fragments.DisplayDataFragment

/**
 * Instantiating Room DB Builder only one time
 * as it is fairly expensive
 */
object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE =
                    buildRoomDB(
                        context
                    )
            }
        }
        return INSTANCE!!
    }

    // Creating database using Room
    private fun buildRoomDB(context: Context): AppDatabase? {
        return Room.databaseBuilder(context, AppDatabase::class.java, "person_db")
            .fallbackToDestructiveMigration().build()
    }
}