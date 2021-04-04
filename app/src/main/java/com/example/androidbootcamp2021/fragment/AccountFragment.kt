package com.example.androidbootcamp2021.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidbootcamp2021.MainActivity
import com.example.androidbootcamp2021.R
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkLogin()
        getSharedPref()
        setListeners()
    }

    /**
     * Check if user logged in
     * If not then redirect to Login fragment
     */
    private fun checkLogin() {
        if (isUserLoggedIn()) {
            val name = getSharedPref()
            name_TV.text = "Welcome " + name.toString()
        }
        else {
            Toast.makeText(activity, getString(R.string.name_must_enter_info), Toast.LENGTH_LONG).show()
            navigateToLoginDestination()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name = sharedPreferences?.getString(MainActivity.NAME_KEY, null)
        return name != null
    }

    private fun getSharedPref(): String? {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(MainActivity.NAME_KEY, null)
    }

    private fun setListeners() {
        logout_BTN.setOnClickListener {
            removeSharedPrefData()
            navigateToLoginDestination()
        }
    }

    private fun navigateToLoginDestination() {
        findNavController().navigate(R.id.action_global_loginFragment)
    }

    private fun removeSharedPrefData() {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val sharedPreferencesEditor = sharedPreferences?.edit()
        sharedPreferencesEditor?.remove(MainActivity.NAME_KEY)
        sharedPreferencesEditor?.apply()
    }
}