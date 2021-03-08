package com.example.androidbootcamp2021

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_file_handling.*
import java.io.FileInputStream

class FileHandlingActivity : AppCompatActivity() {

    companion object {
        const val FILE_NAME = "myFile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_handling)

        fileHandlingWriteBtn.setOnClickListener {
            writeToFile()
        }

        fileHandlingReadBtn.setOnClickListener {
            readFromFile()
        }

    }

    private fun readFromFile() {
        try {
            val fIn: FileInputStream = openFileInput(FILE_NAME)

            var c: Int
            var stringTemp = ""

            while (fIn.read().also { c = it } != -1) {
                stringTemp += c.toChar().toString()
            }

            if (stringTemp.isEmpty()) {
                Toast.makeText(
                    this,
                    "Enter text and then click Submit button first",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                fileHandlingEditText.setText(stringTemp)
            }
            fIn.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun writeToFile() {
        try {
            // Open file and specify the mode
            val fOut = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)

            // Get text
            val textToWrite: String? = fileHandlingEditText.text.toString()

            if (!textToWrite.isNullOrEmpty()) {
                fileHandlingEditText.text!!.clear()

                // Write to file in ByteArray
                fOut.write(textToWrite.toByteArray())

                // Close the connection
                fOut.close()

                Toast.makeText(this, "Now click on Read button to get the text", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(
                    this,
                    "Enter text and then click Submit button first",
                    Toast.LENGTH_LONG
                ).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}