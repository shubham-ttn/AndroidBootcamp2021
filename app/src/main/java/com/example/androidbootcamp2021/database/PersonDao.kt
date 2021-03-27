package com.example.androidbootcamp2021.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidbootcamp2021.PersonDataClass

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    fun getAllPersonsDetails(): List<PersonDataClass>

    @Insert
    fun insertPersonDetails(person: PersonDataClass)
}