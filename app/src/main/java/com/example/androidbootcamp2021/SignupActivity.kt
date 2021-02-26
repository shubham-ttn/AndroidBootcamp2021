package com.example.androidbootcamp2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


// Create one signup activity having “user name”, “email-id”, “phone number”, “password” with all fields mandatory.


class SignupActivity : AppCompatActivity() {

    // Pattern for email validation
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onCreate")

        // Getting view reference
        val uNameView  = findViewById<EditText>(R.id.editTextPersonUserName)
        val emailView  = findViewById<EditText>(R.id.editTextPersonEmail)
        val phoneNumView  = findViewById<EditText>(R.id.editTextPersonPhoneNum)
        val passwordView  = findViewById<EditText>(R.id.editTextTextPassword)
        val signupBtn = findViewById<Button>(R.id.signUpButton)

        // Attaching onClick listener
        signupBtn.setOnClickListener {
            when {
                // Checking if fields are blank
                uNameView.text.isBlank() -> uNameView.error = "Enter Username"
                emailView.text.toString().isBlank() -> emailView.error = "Enter email"
                !emailView.text.toString().trim().matches(emailPattern.toRegex()) -> emailView.error = "Enter valid email"
                phoneNumView.text.toString().isBlank() -> phoneNumView.error = "Enter phone number"
                passwordView.text.toString().isBlank() -> passwordView.error = "Enter password"
                else -> {
                    val uName = uNameView.text.toString()
                    val email = emailView.text.toString()
                    val phoneNum = phoneNumView.text.toString()
                    val password = passwordView.text.toString()

                    val intent = Intent(this, HomepageActivity::class.java)
                    intent.putExtra("userName", uName)
                    intent.putExtra("email", email)
                    intent.putExtra("phoneNum", phoneNum)
                    intent.putExtra("password", password)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onDestroy")
    }
}