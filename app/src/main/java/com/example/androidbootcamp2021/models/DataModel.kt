package com.example.androidbootcamp2021.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("id")
    val postID: Int,
    @SerializedName("title")
    val postTitle: String,
    @SerializedName("body")
    val postBody: String
)