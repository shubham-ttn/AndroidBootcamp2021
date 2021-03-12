package com.example.androidbootcamp2021.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidbootcamp2021.EmployeeDataClass

// Entity means a row
@Database(entities = arrayOf(EmployeeDataClass::class), version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun employeeDao(): RoomEmployeeDoa
}
