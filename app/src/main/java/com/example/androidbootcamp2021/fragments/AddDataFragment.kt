package com.example.androidbootcamp2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.androidbootcamp2021.PersonDataClass
import com.example.androidbootcamp2021.R
import com.example.androidbootcamp2021.database.DatabaseBuilder
import com.example.androidbootcamp2021.viewmodels.PersonViewModel
import kotlinx.android.synthetic.main.fragment_add_data.*
import java.util.concurrent.Executors

class AddDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_data, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
        addData_BTN.setOnClickListener {
            addDataInRoomDB()
            Toast.makeText(context, "Data added successfully", Toast.LENGTH_LONG).show()
            fragmentManager?.popBackStack()
        }

        /**
         * Go back to previous fragment
         * from the stack
         */
        cancelAddingDetails_BTN.setOnClickListener {
            fragmentManager?.popBackStack()

        }
    }

    private fun addDataInRoomDB() {
        /*val roomDatabaseBuilder = context?.let { DatabaseBuilder.getInstance(it) }
          Executors.newSingleThreadExecutor().execute {
              roomDatabaseBuilder!!.personDao().insertPersonDetails(
                  PersonDataClass(
                      personId = null,
                      personName = personName_ET.text.toString(),
                      personContact = personContact_ET.text.toString(),
                      personAddress = personAddress_ET.text.toString()
                  )
              )
          }*/

        val application = activity!!.application
        val personViewModel = ViewModelProvider(this).get(PersonViewModel(application)::class.java)
        personViewModel.addPersonDetails(PersonDataClass(
            personId = null,
            personName = personName_ET.text.toString(),
            personContact = personContact_ET.text.toString(),
            personAddress = personAddress_ET.text.toString()
        ))
    }
}