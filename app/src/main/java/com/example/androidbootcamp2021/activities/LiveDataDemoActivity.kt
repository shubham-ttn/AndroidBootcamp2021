package com.example.androidbootcamp2021.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.fragments.AddDataFragment
import com.example.androidbootcamp2021.fragments.DisplayDataFragment
import kotlinx.android.synthetic.main.fragment_display_data.*

class LiveDataDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_demo)

        addFragmentToView()
    }

    /**
     * Add fragment to container which
     * displays all the person list
     */
    private fun addFragmentToView() {
        // Add fragment to view at runtime
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer_FL, DisplayDataFragment())
        fragmentTransaction.commit()
    }
}