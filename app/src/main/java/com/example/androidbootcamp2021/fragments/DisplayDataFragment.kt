package com.example.androidbootcamp2021.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.androidbootcamp2021.R
import kotlinx.android.synthetic.main.fragment_display_data.*

class DisplayDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addPersonDetails_FAB.setOnClickListener {
            openAddPersonDetailsFragment()
        }
    }

    /**
     * Replace old fragment with another fragment
     * to add the new person details
     */
    private fun openAddPersonDetailsFragment() {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentContainer_FL, AddDataFragment())
        // Add fragment to backstack
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}