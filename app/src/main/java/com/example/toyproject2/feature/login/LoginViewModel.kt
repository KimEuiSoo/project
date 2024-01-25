package com.example.toyproject2.feature.login

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.throw_fornt.util.common.SingleLiveEvent

class LoginViewModel : ViewModel() {
    private val _evnet: SingleLiveEvent<Event> = SingleLiveEvent();
    val event: LiveData<Event>
        get() = _evnet;

    val email: MutableLiveData<String> = MutableLiveData("");

    val password: MutableLiveData<String> = MutableLiveData("");

    fun passwordDelete() {
        password.value = "" // #FF5252
    }

    sealed class Event() {
        data class Fail(var msg: String) : Event()
        object Login : Event()
        object SignUp : Event()
    }
}