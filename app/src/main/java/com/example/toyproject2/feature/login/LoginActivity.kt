package com.example.toyproject2.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toyproject2.R
import com.example.toyproject2.databinding.ActivityLoginBinding

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.event.observe(this){handleEvnet(it)}
    }

    private fun handleEvnet(event: LoginViewModel.Event){
        when(event){
            is LoginViewModel.Event.Login -> login()
            is LoginViewModel.Event.SignUp -> signUp()
            is LoginViewModel.Event.Fail -> Toast.makeText(this@LoginActivity, event.msg, Toast.LENGTH_LONG)
        }
    }

    private fun login(){

    }

    private fun signUp(){

    }
}