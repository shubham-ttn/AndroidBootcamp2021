package com.example.androidbootcamp2021.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("posts")
    val posts: ArrayList<DataModel>
)