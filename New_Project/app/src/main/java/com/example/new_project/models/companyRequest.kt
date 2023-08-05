package com.example.new_project.models

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface companyRequest {
    @GET("fapi")
    fun getRequest(
        @Query("key") key: String,
        @Query("gb") gb:String,
        @Query("q") q:String,
        @Query("type") type:String
    ) : Call<responeBody>

}