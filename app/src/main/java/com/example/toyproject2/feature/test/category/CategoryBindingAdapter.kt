package com.example.toyproject2.feature.test.category

import androidx.databinding.BindingAdapter
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

@BindingAdapter("onNavigationItemSelected")
fun NavigationView.bindOnNavigationItemSelectedListener(
    listener: NavigationView.OnNavigationItemSelectedListener,
) {
    this.setNavigationItemSelectedListener(listener)
}