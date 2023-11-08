package com.example.toyproject2.feature.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IdViewModel: ViewModel() {
    private val _evnet: MutableLiveData<Event> = MutableLiveData();

    val event: LiveData<Event>
        get() = _evnet

    sealed class Event(){
        data class ID(val id: String): Event()
    }
}