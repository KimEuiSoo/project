package com.example.toyproject2.feature.signUp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toyproject2.R
import com.example.toyproject2.data.local.SignUp
import com.example.toyproject2.databinding.ActivityPasswordBinding
import com.example.toyproject2.feature.home.HomeActivity

class PasswordActivity : BindingActivity<ActivityPasswordBinding>(R.layout.activity_password) {
    private val viewModel: PasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val intent: Intent = getIntent()
        val receive = intent?.getParcelableExtra<SignUp>("id")
        if (receive != null) {
            viewModel.receiveData(receive)
        }

        viewModel.event.observe(this){handleEvent(it)}
        viewModel.password.observe(this){checkPassword()}
    }

    private fun checkPassword(){
        viewModel.checkPassword()
    }

    private fun handleEvent(event: PasswordViewModel.Event){
        finish()
        val intent: Intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("signUp", viewModel.signUp)
        startActivity(intent)
    }
}