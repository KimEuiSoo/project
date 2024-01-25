package com.example.toyproject2.feature.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.throw_fornt.util.common.SingleLiveEvent
import com.example.toyproject2.data.local.SignUp
import kotlinx.coroutines.launch

class IdViewModel : ViewModel() {
    lateinit var signUp: SignUp
    val emailId: MutableLiveData<String> = MutableLiveData("")

    private val _evnet: SingleLiveEvent<Event> = SingleLiveEvent()
    val event: LiveData<Event>
        get() = _evnet
    private val _btn: MutableLiveData<Boolean> = MutableLiveData(false)
    val btn: LiveData<Boolean>
        get() = _btn

    fun checkEmaild() {
        if (emailId.value.toString().length >= 1) _btn.value = true;
        else _btn.value = false
    }

    fun nextPage() {
        signUp = SignUp(emailId.value.toString(), "")
        _evnet.value = Event.ID
    }

    sealed class Event() {
        object ID : Event()
    }
}