package com.example.toyproject2.feature.test.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.throw_fornt.util.common.BindingFragment
import com.example.toyproject2.R
import com.example.toyproject2.databinding.FragmentCategoryBinding
import com.example.toyproject2.feature.test.category.detail.DetailCategoryFragment
import com.example.toyproject2.model.TestGlobal
import com.google.android.material.navigation.NavigationView

class CategoryFragment : BindingFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    private val viewModel: CategoryViewModel by viewModels()
    private val globalHelper: TestGlobal = TestGlobal()
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Log.d("fragment_data", "parent_onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            Log.d("fragment_data", "parent_onViewCreate")
        } else Log.d("fragment_data", "${savedInstanceState.toString()}")
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.category()
        navigationView = view.findViewById(R.id.nv_navigation_tab)
        setupViewModel()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("fragment_data", "parent_onSaveInstanceState")
        outState.putInt(KEY, 1)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment_data", "parent_onDestroy")
    }

    private fun setupViewModel() {
        viewModel.currentCategoryType.observe(viewLifecycleOwner) {
            changeFragment(it)
        }
    }

    private fun changeFragment(categoryType: DetailCategoryType) {

        childFragmentManager.commit {
            setReorderingAllowed(true)

            childFragmentManager.fragments.forEach(::hide)
            childFragmentManager.findFragmentByTag(categoryType.tag)?.let {
                show(it)
            } ?: run {
                add(
                    R.id.fcv_container_category,
                    createFragment(categoryType),
                    categoryType.tag
                ).addToBackStack(null)
            }
        }
//        childFragmentManager.popBackStack()
    }

    private fun createFragment(category: DetailCategoryType): Fragment {
        return DetailCategoryFragment(globalHelper.detailCategoryList(category))
    }

    companion object {
        private const val KEY: String = "KEY";
    }
}