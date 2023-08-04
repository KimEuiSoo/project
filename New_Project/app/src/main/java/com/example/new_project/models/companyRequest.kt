package com.example.new_project.models

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

interface companyRequest {
    @GET("")
    fun request(
        @Field("gb") gb:String,
        @Field("q") q:String,
        @Field("type") type:String
    ) : Call<responeBody>
}