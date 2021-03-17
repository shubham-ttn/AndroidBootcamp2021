package com.example.androidbootcamp2021.retrofit

import com.example.androidbootcamp2021.models.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    // Define end point
    @GET("v2/posts.json")
    fun getPosts(): Call<List<DataModel>>
}
