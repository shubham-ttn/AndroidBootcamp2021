package com.example.androidbootcamp2021.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("name")
    val postName: String,
    @SerializedName("message")
    val postMessage: String,
    @SerializedName("profileImage")
    val postProfileImgURL: String
)