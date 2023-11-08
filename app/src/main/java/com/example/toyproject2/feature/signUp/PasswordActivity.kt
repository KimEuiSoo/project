package com.example.toyproject2.feature.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toyproject2.R
import com.example.toyproject2.databinding.ActivityPasswordBinding

class PasswordActivity : BindingActivity<ActivityPasswordBinding>(R.layout.activity_password) {
    private val viewModel: PasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.event.observe(this){handleEvent(it)}
        viewModel.password.observe(this){checkPassword()}
    }

    private fun checkPassword(){
        viewModel.checkPassword()
    }

    private fun handleEvent(event: PasswordViewModel.Event){

    }
}