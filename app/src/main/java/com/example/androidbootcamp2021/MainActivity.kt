package com.example.androidbootcamp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val databaseManager = SQLiteDatabaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDummyDataBtn.setOnClickListener {
            insertDataInDB()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        sqliteDemoBtn.setOnClickListener {
            startActivity(Intent(this, DatabaseActivity::class.java))
        }

//        TODO()
//        getDataFromRoom()


    }

    private fun insertDataInDB() {
        // insert data in DB
        databaseManager.insertValue(EmployeeDataClass(name = "Shubham Pandey", contact = "9912345678", address = "New Delhi"))
        databaseManager.insertValue(EmployeeDataClass(name = "Gaurav Rawat", contact = "123456789", address = "Delhi"))
        databaseManager.insertValue(EmployeeDataClass(name = "Pawan Gupta", contact = "3264464789", address = "Noida"))
    }
}