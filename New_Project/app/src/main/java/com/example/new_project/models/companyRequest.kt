package com.example.new_project.models

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

interface companyRequest {
    @GET("fapi")
    fun request(
        @Query("key") key: String,
        @Query("gb") gb:String,
        @Query("q") q:String,
        @Query("type") type:String
    ) : Call<responeBody>
}