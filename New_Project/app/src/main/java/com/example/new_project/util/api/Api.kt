package com.example.new_project.util.api

import com.example.new_project.models.Global
import com.example.new_project.models.companyRequest
import com.example.new_project.models.responeBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.net.URL

class Api {
}

class registerApi private constructor() {
    companion object {
        const val url = "https://bizno.net/api/"
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

    /*
    return 1 : 정상적으로 사업자등록번호로 조회
    return 2 : 없는 사업자등록번호
    return 3 : 조회실패 or 타임아웃
    */
    fun recievData(companyNum: String): Int = runBlocking  {
        var check = 2
        if (companyNum.equals("")) return@runBlocking check

        try {
            val urls = URL(url)
            val retrofit = Retrofit.Builder()
                .baseUrl(urls)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val persondata: companyRequest = retrofit.create(companyRequest::class.java)

            val response: Response<responeBody> = withContext(Dispatchers.IO) {
                try {
                    persondata.getRequest(apiKey, "1", companyNum, "json").execute()
                } catch (e: Exception) {
                    null
                }!!
            }

            if (response != null && response.isSuccessful &&
                (response.body()?.resultCode == "0" || response.body()?.resultCode == "-1")
            ) {
                if (response.body()?.resultCode == "0") {
                    check = 1
                    Global.getCompany(response.body()!!.items.get(0).company)
                }
                else check = 2
            } else {
                check = 3
            }
        } catch (e: Exception) {
            check = 3
        }
        return@runBlocking check
    }
}