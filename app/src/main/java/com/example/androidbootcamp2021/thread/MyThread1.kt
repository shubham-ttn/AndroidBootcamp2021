package com.example.androidbootcamp2021.thread

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class MyThread1(private val context: Context): Thread() {

    val TAG = "MyThread1"

    override fun run() {
        super.run()

        for (i in 5 downTo 0) {
            Log.i(TAG, "is running, Iteration: $i")
        }

        try {
            Thread.sleep(500)
        }
        catch (e: Exception) {
            Toast.makeText(context, "Exception: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }
}