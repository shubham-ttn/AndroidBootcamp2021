package com.example.androidbootcamp2021.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class BoundService: Service() {

    private val myBinder = MyLocalBinder()

    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.US)
        return dateformat.format(Date())
    }

    class MyLocalBinder: Binder() {
        fun getService(): BoundService {
            return BoundService()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }
}