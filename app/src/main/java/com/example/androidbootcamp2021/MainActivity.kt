package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var colorViewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize colorViewModel
        colorViewModel = ViewModelProvider(this).get(ColorViewModel::class.java)

        mainActivity_CL.setBackgroundColor(colorViewModel.selectedColor)

        changeBackground_BTN.setOnClickListener {
            colorViewModel.getRandomBackgroundColor()
            mainActivity_CL.setBackgroundColor(colorViewModel.selectedColor)
        }
    }

}