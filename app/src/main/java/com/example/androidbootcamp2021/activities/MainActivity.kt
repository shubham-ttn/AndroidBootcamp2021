package com.example.androidbootcamp2021.activities

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.example.androidbootcamp2021.EmployeeDataClass
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.roomdemo.RoomDatabaseBuilder
import com.example.androidbootcamp2021.sqlitedemo.SQLiteDatabaseManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    val PICKFILE_REQUEST_CODE = 1
    val TAG = "FilePickerActvity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using Kotlin Extensions so we don't
        // need to get the reference of view
        // We can directly use the id of view
        addSQLiteDummyDataBtn.setOnClickListener {
            insertDataInDBUsingSQLite()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        sqliteDemoBtn.setOnClickListener {
            startActivity(Intent(this, DatabaseActivity::class.java).putExtra(
                BUTTON_CLICKED_KEY,
                SQLITE_DEMO_BTN
            ))
        }

        addDummyRoomDataBtn.setOnClickListener {
            insertDataInDBUsingRoom()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        roomDemoBtn.setOnClickListener {
            startActivity(Intent(this, DatabaseActivity::class.java).putExtra(
                BUTTON_CLICKED_KEY,
                ROOM_DEMO_BTN
            ))
        }

        openFileBtn.setOnClickListener {
            chooseFile()
        }


    }

    private fun chooseFile() {
        var chooseFile = Intent(Intent.ACTION_GET_CONTENT)
        chooseFile.type = "*/*"
        chooseFile = Intent.createChooser(chooseFile, "Select a file")
        startActivityForResult(chooseFile, PICKFILE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PICKFILE_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val fileContentURI = data?.data
                    Log.i(TAG, "File URI: $fileContentURI")

                    openFile(fileContentURI!!)
                }
            }

        }
    }

    private fun getType(fileContentURI: Uri): String {

        return if (fileContentURI.scheme.equals(ContentResolver.SCHEME_CONTENT)) {
            val cr = contentResolver
            cr.getType(fileContentURI)!!
        } else {
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileContentURI.toString())!!
        }
    }

    private fun openFile(uri: Uri) {

        val intent = Intent(Intent.ACTION_VIEW)
        val fileType = getType(uri)
        val splitType = fileType.split("/")[1]
        val fileExtension = ".$splitType"


        Log.i(TAG, "File Type: $fileType")
        Log.i(TAG, "File Extension: $fileExtension")

        // Check what kind of file you are trying to open, by comparing the fileExtension with extensions.
        // When the if condition is matched, plugin sets the correct intent (mime) type,
        // so Android knew what application to use to open the file
        if (fileExtension.toString().contains(".doc") || fileExtension.toString().contains(".docx")) {
            // Word document
            intent.setDataAndType(uri, "application/msword");
        } else if (fileExtension.toString().contains(".pdf")) {
            // PDF file
            intent.setDataAndType(uri, "application/pdf");
        } else if (fileExtension.toString().contains(".ppt") || fileExtension.toString().contains(".pptx")) {
            // Powerpoint file
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if (fileExtension.toString().contains(".xls") || fileExtension.toString().contains(".xlsx")) {
            // Excel file
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if (fileExtension.toString().contains(".zip") || fileExtension.toString().contains(".rar")) {
            // WAV audio file
            intent.setDataAndType(uri, "application/x-wav");
        } else if (fileExtension.toString().contains(".rtf")) {
            // RTF file
            intent.setDataAndType(uri, "application/rtf");
        } else if (fileExtension.toString().contains(".wav") || fileExtension.toString().contains(".mp3")) {
            // WAV audio file
            intent.setDataAndType(uri, "audio/x-wav");
        } else if (fileExtension.toString().contains(".gif")) {
            // GIF file
            intent.setDataAndType(uri, "image/gif");
        } else if (fileExtension.toString().contains(".jpg") || fileExtension.toString()
                .contains(".jpeg") || fileExtension.toString().contains(".png")
        ) {
            // JPG and PNG file
            intent.setDataAndType(uri, "image/jpeg");
            Log.i(TAG, "Image selected")
        } else if (fileExtension.toString().contains(".txt")) {
            // Text file
            intent.setDataAndType(uri, "text/plain");
        } else if (fileExtension.toString().contains(".3gp") || fileExtension.toString()
                .contains(".mpg") || fileExtension.toString().contains(".mpeg") || fileExtension.toString()
                .contains(".mpe") || fileExtension.toString().contains(".mp4") || fileExtension.toString()
                .contains(".avi")
        ) {
            // Video files
            intent.setDataAndType(uri, "video/*");
        } else {
            //if you want you can also define the intent type for any other file

            //additionally use else clause below, to manage other unknown extensions
            //in this case, Android will show all applications installed on the device
            //so you can choose which application to use
            intent.setDataAndType(uri, "*/*");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun insertDataInDBUsingRoom() {
        val database = RoomDatabaseBuilder.getInstance(this)

        Executors.newSingleThreadExecutor().execute {
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Mayank",
                    contact = "9912345678",
                    address = "New Delhi"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Rohit",
                    contact = "123456789",
                    address = "Delhi"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Sahil",
                    contact = "3264464789",
                    address = "Noida"
                )
            )

        }
    }

    private fun insertDataInDBUsingSQLite() {

        val databaseManager =
            SQLiteDatabaseManager(this)

        // insert data in DB
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "Shubham Pandey",
                contact = "9912345678",
                address = "New Delhi"
            )
        )
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "Gaurav Rawat",
                contact = "123456789",
                address = "Delhi"
            )
        )
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "Pawan Gupta",
                contact = "3264464789",
                address = "Noida"
            )
        )
    }

    companion object {
        const val BUTTON_CLICKED_KEY = "BUTTON_CLICKED"
        const val SQLITE_DEMO_BTN = "SQLITE_DEMO_BTN"
        const val ROOM_DEMO_BTN = "ROOM_DEMO_BTN"
    }
}
