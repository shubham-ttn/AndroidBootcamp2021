package com.example.androidbootcamp2021.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.viewmodels.ColorViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var colorViewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize colorViewModel
        colorViewModel = ViewModelProvider(this).get(ColorViewModel::class.java)

       attachClickListeners()
    }

    override fun onResume() {
        super.onResume()

        // get last updated value
        // So that in case of configuration change
        // Last value is get used
        mainActivity_CL.setBackgroundColor(colorViewModel.selectedColor)
    }

    private fun attachClickListeners() {
        changeBackground_BTN.setOnClickListener {
            colorViewModel.getRandomBackgroundColor()
            mainActivity_CL.setBackgroundColor(colorViewModel.selectedColor)
        }

        liveDataDemo_BTN.setOnClickListener {
            startActivity(Intent(this, LiveDataDemoActivity::class.java))
        }
    }

}