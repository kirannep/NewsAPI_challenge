package com.example.newsapifragments.network

import com.example.newsapifragments.model.Articles
import com.example.newsapifragments.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetNewsRequest {
    @GET("top-headlines")
    fun getnewsrequest(@Query("country" ) country:String,@Query("apiKey") apiKey:String ) : Call<Results>

}