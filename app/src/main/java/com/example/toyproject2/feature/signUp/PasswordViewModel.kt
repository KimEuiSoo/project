package com.example.toyproject2.feature.signUp

import android.app.Application
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.throw_fornt.util.common.SingleLiveEvent
import com.example.toyproject2.R
import com.example.toyproject2.data.local.SignUp

class PasswordViewModel() : ViewModel() {
    lateinit var signUp: SignUp
    var id: String = ""

    val password: MutableLiveData<String> = MutableLiveData("")

    private val pwPattern =
        "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[\\\$`~!@\$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}\$"

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event>
        get() = _event
    private val _correct: MutableLiveData<Boolean> = MutableLiveData(false)
    val correct: LiveData<Boolean>
        get() = _correct

    private val _passwordCheck: MutableLiveData<Int?> = MutableLiveData(Color.parseColor("#8E9398"))
    val passwordCheck: LiveData<Int?>
        get() = _passwordCheck

    fun receiveData(item: SignUp) {
        id = item.email
    }

    fun nextPage() {
        signUp = SignUp(id, password.value.toString())
        _event.value = Event.Password
    }

    fun checkPassword() {
        if (Regex(pwPattern).find(password.value.toString()) != null && password.value.toString().length>=1) {
            _correct.value = true
            _passwordCheck.value = Color.parseColor("#00A3FF")
        } else if(Regex(pwPattern).find(password.value.toString()) == null && password.value.toString().length>=1){
            _correct.value = false
            _passwordCheck.value = Color.parseColor("#FF5252")
        }
        else{
            _correct.value = false
            _passwordCheck.value = Color.parseColor("#8E9398")
        }
    }

    fun passwordDelete() {
        password.value = "" // #FF5252
    }

    sealed class Event() {
        object Password : Event()
    }
}