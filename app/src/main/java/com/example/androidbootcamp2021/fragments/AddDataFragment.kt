package com.example.androidbootcamp2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidbootcamp2021.R
import kotlinx.android.synthetic.main.fragment_add_data.*
import kotlinx.android.synthetic.main.fragment_display_data.*

class AddDataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
        addData_BTN.setOnClickListener {
            // TODO
        }

        /**
         * Go back to previous fragment
         * from the stack
         */
        cancelAddingDetails_BTN.setOnClickListener {
            fragmentManager?.popBackStack()

        }
    }
}