package com.example.androidbootcamp2021

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val listViewType = mutableListOf<Int>()

    private var startPage = 1
    private var isLoading = false
    private val limit = 4

    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: MyCustomAdapter
    private lateinit var layoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        // Set layout for RecyclerView
        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        getPage()

        /**
        * To enable Pagination, we must detect the user reaching the end of the list (RecyclerView).
        * PaginationScrollListener allows us to do so.
         */
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                // dy means vertical scroll position
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                    // use isLastPage to stop when last page shown
                    // to the users
                    if (!isLoading) {
                        if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                            startPage++
                            getPage()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getPage() {
        isLoading = true

        // When loading
        // show progressBar
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        // For endless scrolling
        val start = (startPage - 1) * limit
        val end = (startPage) * limit

        for (i in start..end) {
            when {
                i % 2 == 0 -> {
                    listViewType.add(MyCustomAdapter.TEXT_OFFER_VIEW)
                }
                i % 3 == 0 -> {
                    listViewType.add(MyCustomAdapter.IMAGE_OFFER_VIEW)
                }
                else -> {
                    listViewType.add(MyCustomAdapter.IMAGE_WITH_BANNER_VIEW)
                }
            }
        }
        // Adding delay of 2 seconds
        Handler().postDelayed(
            {
                if (::customAdapter.isInitialized) {
                    // Adapter is already initialized
                    // Just update the data
                    customAdapter.notifyDataSetChanged()
                } else {
                    // attach adapter to recycler view
                    customAdapter = MyCustomAdapter(this, listViewType)
                    recyclerView.adapter = customAdapter
                }
                isLoading = false
                progressBar.visibility = View.GONE
            }, 2000
        )
    }
}