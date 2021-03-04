package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Set layout for RecyclerView
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        val listViewType = mutableListOf<Int>(
            // Accessing companion object
            // to identify the type of view
            MyCustomAdapter.IMAGE_OFFER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_WITH_BANNER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_OFFER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_WITH_BANNER_VIEW,
            MyCustomAdapter.IMAGE_OFFER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_OFFER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_WITH_BANNER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_OFFER_VIEW,
            MyCustomAdapter.TEXT_OFFER_VIEW,
            MyCustomAdapter.IMAGE_WITH_BANNER_VIEW
        )

        // attach adapter and pass data
        val customAdapter = MyCustomAdapter(this, listViewType)
        recyclerView.adapter = customAdapter
    }
}