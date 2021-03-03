package com.example.androidbootcamp2021

import android.graphics.Color
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Custom Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Orders"
        toolbar.setTitleTextColor(Color.WHITE)
        setActionBar(toolbar)

        // add data in recycler view
        val dataSet = ArrayList<DataClass>()
        for (i in 1..10) {
            dataSet.add(
                DataClass(
                    "Ice Cream Sundae",
                    "145, Mall of India",
                    R.drawable.img2,
                    3,
                    "520 reviews",
                    "01 Mar 2019 11 : 30 AM",
                    "Rs. 180"
                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Set layout for RecyclerView
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        // attach adapter
        val customAdapter = CustomAdapter(dataSet)
        recyclerView.adapter = customAdapter

    }

}