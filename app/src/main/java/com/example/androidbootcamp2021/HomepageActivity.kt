package com.example.androidbootcamp2021

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.net.URI

class HomepageActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // receiving text from intent
        val intent = intent
        val uName = intent.getStringExtra("userName")
        val email = intent.getStringExtra("email")
        val phoneNum = intent.getStringExtra("phoneNum")
        val password = intent.getStringExtra("password")

        // Getting view reference
        val uNameView = findViewById<TextView>(R.id.uname)
        val emailView = findViewById<TextView>(R.id.email)
        val phoneNumView = findViewById<TextView>(R.id.phnNum)
        val passwordView = findViewById<TextView>(R.id.pass)
        val urlView = findViewById<EditText>(R.id.urlEditText)

        // Replace text in view
        uNameView.text = "Username: $uName"
        emailView.text = "Email: $email"
        phoneNumView.text = "Phone Num: $phoneNum"
        passwordView.text = "Password: $password"

        val browserBtn = findViewById<Button>(R.id.openBrowserIntent)
        val cameraBtn = findViewById<Button>(R.id.cameraButton)


        browserBtn.setOnClickListener {
            if (urlView.text.isNotBlank()) {
                // Parsing Url in Android URI
                val uri = Uri.parse("https://" + urlView.text.toString())

                // create Implicit intent for browser
                val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
                startActivity(launchBrowser)
            } else {
                // show error
                urlView.error = "Enter URL"
            }
        }

        cameraBtn.setOnClickListener {
            // It will check if permission is already
            // granted or not
            val value =
                ContextCompat.checkSelfPermission(this, "android.permission.CAMERA")
            when (value) {
                PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Camera permission already granted!", Toast.LENGTH_LONG)
                        .show()
                    Log.e("USER_PERMISSION", "PERMISSION_GRANTED")
                    //no need for permission, do the operation
                }
                // Permission not already given
                PackageManager.PERMISSION_DENIED -> {
                    Log.e("USER_PERMISSION", "PERMISSION_DENIED")
                    //ask for permission
                    askForPermission()
                }
            }
        }
    }

    private fun askForPermission() {
        val permissions = arrayOf("android.permission.CAMERA")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, 1001)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted
                Toast.makeText(this, "Camera permission granted!", Toast.LENGTH_LONG).show()
                Log.e("USER_PERMISSION", "PERMISSION_GRANTED ${permissions[0]}")
            } else {
                // permission denied
                Toast.makeText(this, "Camera permission denied. You can change this from settings.", Toast.LENGTH_LONG)
                    .show()
                Log.e("USER_PERMISSION", "PERMISSION_DENIED ${permissions[0]}")
            }
        }
    }
}