package com.example.androidbootcamp2021

import android.app.Application
import android.content.Context
import android.service.autofill.Dataset
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class ItemViewModel(application: Application): AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val itemRepository: ItemRepository = ItemRepository(context)

    val isItemFavorite = liveData {
        emit(itemRepository.getFavoriteItem())
    }

    fun removeFromFavorite(){
        itemRepository.removeFavoriteItem()
    }

    fun saveInFavorite(favoriteItem: ItemDataClass) {
        itemRepository.saveFavoriteItem(favoriteItem)
    }
}