package com.example.androidbootcamp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using Kotlin Extensions so we don't
        // need to get the reference of view
        // We can directly use the id of view
        addSQLiteDummyDataBtn.setOnClickListener {
            insertDataInDBUsingSQLite()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        sqliteDemoBtn.setOnClickListener {
            startActivity(Intent(this, DatabaseActivity::class.java).putExtra(BUTTON_CLICKED_KEY, SQLITE_DEMO_BTN))
        }

        addDummyRoomDataBtn.setOnClickListener {
            insertDataInDBUsingRoom()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        roomDemoBtn.setOnClickListener {
            startActivity(Intent(this, DatabaseActivity::class.java).putExtra(BUTTON_CLICKED_KEY, ROOM_DEMO_BTN))
        }
    }

    private fun insertDataInDBUsingRoom() {
        val database = RoomDatabaseBuilder.getInstance(this)

        Executors.newSingleThreadExecutor().execute {
            database.employeeDao().insertEmployeeDetails(EmployeeDataClass(name = "Mayank", contact = "9912345678", address = "New Delhi"))
            database.employeeDao().insertEmployeeDetails(EmployeeDataClass(name = "Rohit", contact = "123456789", address = "Delhi"))
            database.employeeDao().insertEmployeeDetails(EmployeeDataClass(name = "Sahil", contact = "3264464789", address = "Noida"))

        }
    }

    private fun insertDataInDBUsingSQLite() {

        val databaseManager = SQLiteDatabaseManager(this)

        // insert data in DB
        databaseManager.insertValue(EmployeeDataClass(name = "Shubham Pandey", contact = "9912345678", address = "New Delhi"))
        databaseManager.insertValue(EmployeeDataClass(name = "Gaurav Rawat", contact = "123456789", address = "Delhi"))
        databaseManager.insertValue(EmployeeDataClass(name = "Pawan Gupta", contact = "3264464789", address = "Noida"))
    }

    companion object {
        const val BUTTON_CLICKED_KEY = "BUTTON_CLICKED"
        const val SQLITE_DEMO_BTN = "SQLITE_DEMO_BTN"
        const val ROOM_DEMO_BTN = "ROOM_DEMO_BTN"
    }
}
