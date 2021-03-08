package com.example.androidbootcamp2021

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        // Getting shared preferences reference
        val preferences = this.getPreferences(Context.MODE_PRIVATE)

        sharedPrefSubmitBtn.setOnClickListener {

            // Initialising editor for shared preferences
            val editor = preferences.edit()

            val textToPut: String? = sharedPrefEditText.text.toString()

            if (textToPut.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_LONG).show()
            }
            else {

                // Clear the text after saving it
                // to variable
                sharedPrefEditText.text!!.clear()

                // Putting values
                editor.putString("SHARED_PREF_TEXT", textToPut)

                // Commit changes
                editor.apply()

                Toast.makeText(this, "Now click on Retrieve button to get the text", Toast.LENGTH_LONG).show()
            }
        }

        sharedPrefRetrieveBtn.setOnClickListener {
            val retrieveSharedPref = preferences.getString("SHARED_PREF_TEXT", "")
            if (retrieveSharedPref.isNullOrEmpty()) {
                Toast.makeText(this, "Enter text and then click Submit button first", Toast.LENGTH_LONG).show()
            }
            else {
                sharedPrefEditText.setText(retrieveSharedPref)
            }
        }
    }
}