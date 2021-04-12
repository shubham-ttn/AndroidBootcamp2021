package com.example.androidbootcamp2021

import android.content.Context
import androidx.lifecycle.MutableLiveData

// Declared this class as open to test with mockito
open class ItemRepository(context: Context) {

    private val itemModel: ItemModel = ItemModel(context)

    fun getFavoriteItem() = itemModel.getFavoriteItems()

    fun saveFavoriteItem(favItem: ItemDataClass) = itemModel.saveFavoriteItems(favItem)

    fun removeFavoriteItem() = itemModel.removeFavoriteItems()
}