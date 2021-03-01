package com.example.androidbootcamp2021

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceFragment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class LaunchingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launching)

        // Get views reference
        val fragDemoBtn = findViewById<Button>(R.id.fragmentDemoBtn)
        val dialogFragmentBtn = findViewById<Button>(R.id.dFragmentDemoBtn)
        val preferenceFragmentBtn = findViewById<Button>(R.id.pFragmentDemobtn)

        // attach on click listeners
        fragDemoBtn.setOnClickListener {
            // send user to next activity
            startActivity(Intent(this, MainActivity::class.java))
        }

        // attach on click listeners
        dialogFragmentBtn.setOnClickListener {
            // Get fragment manager support
            val fragmentManager = supportFragmentManager
            // create onject of class
            val dialogFragmentDemoObj = DialogFragmentDemo()
            // show dialog fragment
            dialogFragmentDemoObj.show(fragmentManager, "Dialog Fragment")
        }

        // attach on click listeners
        preferenceFragmentBtn.setOnClickListener {

        }
    }
}

// Creating Diaglog Fragment
class DialogFragmentDemo : DialogFragment() {

    // It return Dialog after building it
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("Welcome")
            .setMessage("This is Dialog Fragment")
            .setPositiveButton("Okay!") { _, _ -> }
            .create()
}

