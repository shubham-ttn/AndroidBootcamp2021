package com.example.androidbootcamp2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidbootcamp2021.thread.MyThread
import com.example.androidbootcamp2021.thread.MyThread1
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ques 1 : Use start() join() and sleep() methods in single program to execute different threads.
        // See thread directory
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