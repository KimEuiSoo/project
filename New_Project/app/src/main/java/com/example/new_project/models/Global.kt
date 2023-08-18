package com.example.new_project.models

import android.location.Location
import com.example.new_project.util.api.registerApi

class Global {
    companion object {
        var company: String = ""
        var address: String = ""
        lateinit var location: Location
        lateinit var data: List<companyData>

        fun getCompany(input: String){
            company = input
        }
        fun getAddress(input: String){
            company = input
        }
        fun getLocation(input: Location){
            location = input
        }
        fun getItemList(item: List<companyData>){
            data = item
        }
    }
}