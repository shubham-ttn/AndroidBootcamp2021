package com.example.androidbootcamp2021.retrofit

import com.example.androidbootcamp2021.models.DataModel
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // Define end point
    @GET("posts")
    fun getPost(
        // Parameter name
        // Eg. https://jsonplaceholder.typicode.com/posts?id=2
        @Query("id")
        postId: Int
    ): retrofit2.Call<List<DataModel>>
}