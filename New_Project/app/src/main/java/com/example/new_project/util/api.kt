package com.example.new_project.util

import android.content.Context
import android.util.Log
import com.example.new_project.models.companyRequest
import com.example.new_project.models.responeBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.net.URL

class api {
}

class registerApi private constructor(){
    companion object {
        const val url = "https://bizno.net/api/fapi"
        const val apiKey = "ZG1sdG4zNDI2QGdtYWlsLmNvbSAg"


        //SingleTon Pattern(싱글톤 패턴)
        @Volatile
        private var instance: registerApi? = null

        fun getInstance() =
            instance ?: synchronized(registerApi::class.java) {
                instance ?: registerApi().also {
                    instance = it
                }
            }
    }

    fun recievData(companyNum: String): Boolean{
        var check = false
        try{
            var urls = URL(url)
            val retrofit =  Retrofit.Builder()
                .baseUrl(urls)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            var persondata: companyRequest = retrofit.create(companyRequest::class.java)
            persondata.request("1","0000000000","json").enqueue(object: Callback<responeBody>{
                override fun onResponse(call: Call<responeBody>, response: Response<responeBody>) {
                    Log.d("daa", "data")
                }
                override fun onFailure(call: Call<responeBody>, t: Throwable) {
                    check=false
                }
            })
        }
        catch (e:Exception){

        }
        return check
    }
}