package com.example.toyproject2.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toy_project.UserDB
import com.example.toyproject2.R
import com.example.toyproject2.data.local.SignUp
import com.example.toyproject2.databinding.ActivityHomeBinding
import com.example.toyproject2.feature.login.LoginActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: HomeViewModel by viewModels()

    private val userHelper: UserDB by lazy {
        UserDB.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val intent: Intent = getIntent()
        val receive = intent?.getParcelableExtra<SignUp>("signUp")
        if (receive != null) {
//            viewModel.setVisibility(true);
            viewModel.receiveData(receive)
            userHelper.insertData(
                receive.email.toString().trim(),
                receive.password.toString().trim()
            )
        }

        viewModel.event.observe(this) { signUpComplete() }
    }

    fun signUpComplete() {
        finish()
        val intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent);
    }

    override fun onDestroy() {
        userHelper.close()
        super.onDestroy()
    }
}