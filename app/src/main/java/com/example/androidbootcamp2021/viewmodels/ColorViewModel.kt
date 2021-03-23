package com.example.androidbootcamp2021.viewmodels

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ColorViewModel : ViewModel() {
    private val colorArray = arrayOf(
        Color.WHITE,
        Color.CYAN,
        Color.BLACK,
        Color.BLUE,
        Color.DKGRAY,
        Color.GRAY,
        Color.GREEN,
        Color.MAGENTA
    )

    // Assinging a default color
    var selectedColor = colorArray[0]

    fun getRandomBackgroundColor() {
        selectedColor = colorArray[randomNumberGenerator()]
    }

    // Generate random number
    private fun randomNumberGenerator(): Int {
        val startRange = 0
        val endRange = colorArray.size
        return Random.nextInt(startRange, endRange)
    }


}