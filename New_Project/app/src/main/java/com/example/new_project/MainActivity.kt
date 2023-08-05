package com.example.new_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.new_project.ViewModel.mapView.mapView.kakaoMap
import com.example.new_project.ViewModel.mapView.storeView.companyRegistration

class MainActivity : AppCompatActivity() {

    private val mapFragment by lazy{ kakaoMap() }
    private val registerFragment by lazy{ companyRegistration() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentChange(mapFragment)
    }

    private fun fragmentChange(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
    }
}