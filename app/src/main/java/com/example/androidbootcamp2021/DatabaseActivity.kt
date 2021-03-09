package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DatabaseActivity : AppCompatActivity() {

    private val databaseManager = SQLiteDatabaseManager(this)
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        initialiseRecyclerView()


    }

    private fun initialiseRecyclerView() {
        recyclerView = findViewById(R.id.employeeDetailsRecyclerView)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        // get data from Database
        val employeeList = databaseManager.getAllEmpDataFromSQLiteDB()

        val customAdapter = CustomAdapter(this, employeeList)
        recyclerView.adapter = customAdapter
    }
}