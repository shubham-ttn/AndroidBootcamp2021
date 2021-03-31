package com.example.androidbootcamp2021.retrofit

import com.example.androidbootcamp2021.model.DataModel
import retrofit2.http.GET

interface ApiInterface {

    // Define end point
    @GET("posts")
    fun getPost(): retrofit2.Call<List<DataModel>>
}