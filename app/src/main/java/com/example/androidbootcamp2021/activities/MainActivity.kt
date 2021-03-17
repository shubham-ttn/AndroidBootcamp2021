package com.example.androidbootcamp2021.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbootcamp2021.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPostsBtn.setOnClickListener {
            // Open new activity
            startActivity(Intent(this, PostDisplayActivity::class.java))
        }
    }
}