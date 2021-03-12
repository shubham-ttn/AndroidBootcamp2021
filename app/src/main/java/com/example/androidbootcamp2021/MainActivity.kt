package com.example.androidbootcamp2021

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidbootcamp2021.broadcastreceivers.BatteryReceiver
import com.example.androidbootcamp2021.services.MusicService
import com.example.androidbootcamp2021.thread.MyThread
import com.example.androidbootcamp2021.thread.MyThread1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var batteryReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        threadDemo()

        broadcastReceiverDemo()

        serviceDemo()

    }

    override fun onStop() {
        super.onStop()

        // Unregister the Receiver
        // when activity is not visible
        unregisterReceiver(batteryReceiver)
    }

    private fun broadcastReceiverDemo() {
        receiverDemoBtn.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_PHONE_STATE),1);
            }

            // Dynamic registration of Broadcast receiver
            batteryReceiver = BatteryReceiver()
            registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        }
    }

    private fun serviceDemo() {
        val serviceIntent = Intent(applicationContext, MusicService::class.java)
        serviceStartDemoBtn.setOnClickListener {
            startService(serviceIntent)
        }
        serviceStopDemoBtn.setOnClickListener {
            stopService(serviceIntent)
        }
    }

    private fun threadDemo() {
        val myThread = MyThread(this)
        val myThread1 = MyThread1(this)

        myThread.start()

        // Using join() we are telling
        // that this thread must execute its
        // task first
        myThread1.start()
        myThread.join()
    }
}