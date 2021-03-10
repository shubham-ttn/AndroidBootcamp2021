package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DatabaseActivity : AppCompatActivity() {

    private val databaseManager = SQLiteDatabaseManager(this)
    lateinit var recyclerView: RecyclerView

    private val databaseHelper = SQLiteDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        initialiseRecyclerView()


    }

    private fun initialiseRecyclerView() {
        recyclerView = findViewById(R.id.employeeDetailsRecyclerView)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        setupList()

    }

    private fun getDataFromDB(): ArrayList<EmployeeDataClass> {
        // get data from Database
        return databaseManager.getAllEmpDataFromSQLiteDB()
    }

    fun setupList() {
        val employeeList = getDataFromDB()

        val customAdapter = CustomAdapter(this, employeeList)
        recyclerView.adapter = customAdapter

        customAdapter.notifyDataSetChanged()
    }

    fun deleteAnEmployeeData(empID: Int) {
        // get writable database
        val db = databaseHelper.writableDatabase

        val numOfRowDeleted = db.delete(
            SQLiteDatabaseHelper.TABLE_NAME,
            SQLiteDatabaseHelper.COLUMN_ID + "=?",
            arrayOf(empID.toString())
        )

        if (numOfRowDeleted > 0) {
            Toast.makeText(
                this,
                "Employee with Id: $empID is deleted",
                Toast.LENGTH_LONG
            ).show()

            // update the list now

        } else {
            Toast.makeText(this, "There is a problem while deleting the data", Toast.LENGTH_LONG)
                .show()

        }
    }
}