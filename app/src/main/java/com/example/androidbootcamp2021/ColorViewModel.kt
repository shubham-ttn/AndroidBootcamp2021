package com.example.androidbootcamp2021

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.random.Random

class ColorViewModel : ViewModel() {

   companion object {
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
   }

    fun getRandomBackgroundColor(): Int {
        return colorArray[randomNumberGenerator()]
    }

    private fun randomNumberGenerator(): Int {
        val startRange = 0
        val endRange = colorArray.size
        return Random.nextInt(startRange, endRange)
    }


}