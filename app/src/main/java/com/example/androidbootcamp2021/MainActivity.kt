package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

// Observe Lifecycle of Fragment with activity
// Observe Lifecycle of Fragment with activity while using Add, Replace, hide, show, remove

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}