package com.example.toyproject2.feature.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toyproject2.R
import com.example.toyproject2.databinding.ActivityIdBinding

class IdActivity : BindingActivity<ActivityIdBinding>(R.layout.activity_id) {

    private val viewModel: IdViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.emailId.observe(this){checkEmail()}
        viewModel.event.observe(this){handleEvent(it)}
    }

    private fun checkEmail(){
        viewModel.checkEmaild()
    }

    private fun handleEvent(event: IdViewModel.Event){
        val intent: Intent = Intent(this, PasswordActivity::class.java)
        intent.putExtra("id", viewModel.signUp)
        startActivity(intent)
    }
}