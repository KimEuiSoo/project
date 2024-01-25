package com.example.toyproject2.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.throw_fornt.util.common.SingleLiveEvent
import com.example.toyproject2.data.local.SignUp

class HomeViewModel : ViewModel() {
    private val _title: MutableLiveData<String> = MutableLiveData("회원가입")
    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event>
        get() = _event
    private val _email: SingleLiveEvent<String> = SingleLiveEvent()
    val email: LiveData<String>
        get() = _email

    private val _password: SingleLiveEvent<String> = SingleLiveEvent()
    val password: LiveData<String>
        get() = _password

    fun receiveData(item: SignUp) {
        _email.value = item.email
        _password.value = item.password
    }

    fun signUpFinish() {
        _event.value = Event.Complete;
    }

    sealed class Event() {
        object Complete : Event()
    }
}