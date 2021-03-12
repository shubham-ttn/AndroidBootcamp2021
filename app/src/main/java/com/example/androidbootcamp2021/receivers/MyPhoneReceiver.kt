package com.example.androidbootcamp2021.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

class MyPhoneReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
                .equals(TelephonyManager.EXTRA_STATE_RINGING)
        ) {
            showToast(context, "Incoming call...");
        }
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}