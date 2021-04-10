package com.example.androidbootcamp2021

import android.content.Context

class ItemRepository(context: Context) {

    private val dataModel: ItemModel = ItemModel(context)

    fun getFavoriteItem() = dataModel.getFavoriteItems()

    fun saveFavoriteItem(favItem: ItemDataClass) = dataModel.saveFavoriteItems(favItem)

    fun removeFavoriteItem() = dataModel.removeFavoriteItems()
}