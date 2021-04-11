package com.example.androidbootcamp2021

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.item_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemViewModel: ItemViewModel
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = this.application
        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel(application)::class.java)
        setupUI()
        setListeners()
    }

    private fun setListeners() {
        addToFavorite_BTN.setOnClickListener {
            if (itemFavorite_CB.isChecked) {
                itemViewModel.removeFromFavorite()
                Log.i(TAG, "Unchecked")
            }
            else {
                itemViewModel.saveInFavorite(ItemDataClass(itemName_TV.text.toString(), true))
                Log.i(TAG, "Checked")
            }
        }
    }

    private fun setupUI() {
        itemViewModel.isItemFavorite.observe(this, Observer {
            //Log.i(TAG, it.toString())
            itemFavorite_CB.isChecked = it
        })
    }
}