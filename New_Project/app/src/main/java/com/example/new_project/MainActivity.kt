package com.example.new_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.new_project.view.mapView.mapView.kakaoMap
import com.example.new_project.view.mapView.storeView.companyRegistration

class MainActivity : AppCompatActivity() {

    private val mapFragment by lazy{ kakaoMap() }
    private val registerFragment by lazy{ companyRegistration() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentChange(registerFragment)
    }

    private fun fragmentChange(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
    }

    private fun init(){

    }
}