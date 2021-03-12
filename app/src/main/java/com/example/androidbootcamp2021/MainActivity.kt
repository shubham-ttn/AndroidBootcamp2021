package com.example.androidbootcamp2021

import android.content.*
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidbootcamp2021.broadcastreceivers.BatteryReceiver
import com.example.androidbootcamp2021.services.BoundService
import com.example.androidbootcamp2021.services.MusicService
import com.example.androidbootcamp2021.thread.MyThread
import com.example.androidbootcamp2021.thread.MyThread1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var batteryReceiver: BroadcastReceiver = BatteryReceiver()
    var myService: BoundService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        threadDemo()

        receiverDemoBtn.setOnClickListener {
            broadcastReceiverDemo()
        }

        serviceDemo()

        // To use local service
        // first we have to bind it
        bindLocalService()
        // then get that service
        localServiceDemoBtn.setOnClickListener {
            // get current time using local service
            showTime()
        }

    }

    private fun bindLocalService() {
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    private fun showTime() {
        val currentTime = myService?.getCurrentTime()
        Toast.makeText(this, "Current time is: ${currentTime.toString()}", Toast.LENGTH_SHORT)
            .show()
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BoundService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }

    override fun onStop() {
        super.onStop()

        // Unregister the Receiver
        // when activity is not visible
        unregisterReceiver(batteryReceiver)
    }

    private fun broadcastReceiverDemo() {
        receiverDemoBtn.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_PHONE_STATE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_PHONE_STATE), 1
                );
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