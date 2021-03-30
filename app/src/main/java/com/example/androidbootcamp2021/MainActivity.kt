package com.example.androidbootcamp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbootcamp2021.mvp.activity.TicTacToeMVPActivity
import com.example.androidbootcamp2021.mvvm.activity.TicTacToeMVVMActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mvpTTT_BTN.setOnClickListener {
            startActivity(Intent(this, TicTacToeMVPActivity::class.java))
        }

        mvvpTTT_BTN.setOnClickListener {
            startActivity(Intent(this, TicTacToeMVVMActivity::class.java))
        }
    }
}