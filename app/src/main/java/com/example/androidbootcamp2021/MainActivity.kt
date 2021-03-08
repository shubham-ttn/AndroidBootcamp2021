package com.example.androidbootcamp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using Kotlin extensions
        // to get get the view reference
        sharedPrefBtn.setOnClickListener {
            startActivity(Intent(this, SharedPrefActivity::class.java))
        }

        fileHandlingBtn.setOnClickListener {
            startActivity(Intent(this, FileHandlingActivity::class.java))
        }


    }
}