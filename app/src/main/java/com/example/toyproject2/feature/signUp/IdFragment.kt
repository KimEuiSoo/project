package com.example.toyproject2.feature.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.throw_fornt.util.common.BindingFragment
import com.example.toyproject2.R
import com.example.toyproject2.databinding.FragmentIdBinding

class IdFragment : BindingFragment<FragmentIdBinding>(R.layout.fragment_id) {

    private val viewModel: IdViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

//        viewModel.event.observe();
    }
}