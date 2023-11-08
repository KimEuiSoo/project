package com.example.toyproject2.feature.signUp

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.throw_fornt.util.common.SingleLiveEvent
import com.example.toyproject2.R
import com.example.toyproject2.data.local.SignUp

class PasswordViewModel(application: Application) : ViewModel() {
    lateinit var signUp: SignUp
    private val app = application

    val password: MutableLiveData<String> = MutableLiveData("")

    private val pwPattern =
        "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[\\\$`~!@\$!%*#^?&\\\\(\\\\)\\-_=+]).{8,16}\$"

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event>
        get() = _event
    private val _correct: MutableLiveData<Boolean> = MutableLiveData(false)
    val correct: LiveData<Boolean>
        get() = _correct

    val backgroundResource: MutableLiveData<Drawable> = MutableLiveData(ResourcesCompat.getDrawable(app.resources, R.drawable.edit_text, null))

    fun nextPage() {
        _event.value = Event.Password
    }

    fun checkPassword() {
        if (Regex(pwPattern).find(password.value.toString()) != null) {
            _correct.value = true
            backgroundResource.value = ResourcesCompat.getDrawable(app.resources, R.drawable.edit_text_password_error,null)
        } else {
            _correct.value = false
            backgroundResource.value = ResourcesCompat.getDrawable(app.resources, R.drawable.edit_text_password_correct,null)
        }
    }

    fun passwordDelete() {
        password.value = ""
        backgroundResource.value = ResourcesCompat.getDrawable(app.resources, R.drawable.edit_text,null)
    }

    sealed class Event() {
        object Password : Event()
    }
}