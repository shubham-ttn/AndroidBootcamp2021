package com.example.androidbootcamp2021

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.item_row.*

class MainActivity : AppCompatActivity() {

    private lateinit var itemViewModel: ItemViewModel

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
                itemFavorite_CB.isChecked = false
                itemViewModel.removeFromFavorite()
            }
            else {
                itemFavorite_CB.isChecked = true
                itemViewModel.saveInFavorite(ItemDataClass(itemName_TV.text.toString(), itemFavorite_CB.isChecked))
            }
        }
    }

    private fun setupUI() {
        itemViewModel.isItemFavorite.observe(this, Observer {
            itemFavorite_CB.isChecked = it
        })
    }
}