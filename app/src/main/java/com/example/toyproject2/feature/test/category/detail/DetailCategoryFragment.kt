package com.example.toyproject2.feature.test.category.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.throw_fornt.util.common.BindingFragment
import com.example.toyproject2.R
import com.example.toyproject2.data.local.CategoryItem
import com.example.toyproject2.databinding.FragmentDetailCategoryBinding
import com.example.toyproject2.feature.test.category.DetailCategoryType

class DetailCategoryFragment(var items: ArrayList<CategoryItem>) :
    BindingFragment<FragmentDetailCategoryBinding>(R.layout.fragment_detail_category) {
    private val viewModel: DetailCategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Log.d("fragment_data", "child_onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("fragment_data", "child_onViewCreated")
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.dataReceive(items);
    }

    override fun onPause() {
        Log.d("fragment_data", "child_onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("fragment_data", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("fragment_data", "child_onDestroy")
        super.onDestroy()
    }
}