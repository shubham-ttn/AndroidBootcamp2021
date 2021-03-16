package com.example.androidbootcamp2021.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.example.androidbootcamp2021.EmployeeDataClass
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.roomdemo.RoomDatabaseBuilder
import com.example.androidbootcamp2021.sqlitedemo.SQLiteDatabaseManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    val contactHashMap = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sqliteDemoBtn.setOnClickListener {
            startActivity(
                Intent(this, DatabaseActivity::class.java).putExtra(
                    BUTTON_CLICKED_KEY,
                    SQLITE_DEMO_BTN
                )
            )
        }

        addDummyRoomDataBtn.setOnClickListener {
            insertDataInDBUsingRoom()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }

        roomDemoBtn.setOnClickListener {
            startActivity(
                Intent(this, DatabaseActivity::class.java).putExtra(
                    BUTTON_CLICKED_KEY,
                    ROOM_DEMO_BTN
                )
            )
        }

        contentProviderBtn.setOnClickListener {
            loadContacts()
        }


    }

    private fun loadContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS)
            //callback onRequestPermissionsResult
        } else {
            val contactHM = getContacts()
            if (contactHM.size > 0) {
                for (contact in contactHM) {
                    insertDataInDBUsingSQLite(contact.key, contact.value)
                }
                Toast.makeText(this, "${contactHM.size} contact has been added successfully", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                //  toast("Permission must be granted in order to display contacts information")
                Toast.makeText(this, "Allow the permission from settings", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getContacts(): HashMap<String, String> {
        val resolver = contentResolver
        val cursor =
            resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        if (cursor!!.count > 0) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phoneNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                        .toInt()

                if (phoneNumber > 0) {
                    val cursorPhone = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone._ID + "=?",
                        arrayOf(id),
                        null
                    )

                    if (cursorPhone!!.count > 0) {
                        while (cursorPhone.moveToNext()) {
                            val phoneNumValue = cursorPhone.getString(
                                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            //Log.i(TAG, "Contact: $name, $phoneNumValue")
                            contactHashMap[phoneNumValue] = name
                        }
                    }
                    cursorPhone.close()
                }
            }
        }
        else {
            Toast.makeText(this, "No contacts available", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        return contactHashMap
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

    private fun insertDataInDBUsingSQLite(key: String, value: String) {

        val databaseManager =
            SQLiteDatabaseManager(this)

        // insert data in DB
        databaseManager.insertValue(
            EmployeeDataClass(
                name = value,
                contact = key,
                address = "New Delhi"
            )
        )
    }

    companion object {
        const val BUTTON_CLICKED_KEY = "BUTTON_CLICKED"
        const val SQLITE_DEMO_BTN = "SQLITE_DEMO_BTN"
        const val ROOM_DEMO_BTN = "ROOM_DEMO_BTN"
        const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }
}
