package com.example.toyproject2.feature.test.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.throw_fornt.util.common.BindingActivity
import com.example.toyproject2.R
import com.example.toyproject2.databinding.ActivityTestHomeBinding
import com.example.toyproject2.feature.test.cart.CartFragment
import com.example.toyproject2.feature.test.category.CategoryFragment
import com.example.toyproject2.feature.test.home.mainHome.MainFragment
import com.example.toyproject2.feature.test.myPage.MyPageFragment
import com.example.toyproject2.feature.test.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestHomeActivity : BindingActivity<ActivityTestHomeBinding>(R.layout.activity_test_home) {

    private val viewModel: TestHomeViewModel by viewModels()
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        bottomNavigationView = findViewById(R.id.bnv_bottom_tab)
        setupViewModel()
    }

    private fun setupViewModel() {
        bottomNavigationView.selectedItemId = R.id.menu_item_main
        viewModel.currentFragmentType.observe(this) {
            changeFragment(it)
        }
    }

    private fun changeFragment(fragmentType: FragmentType) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)

            supportFragmentManager.fragments.forEach(::hide)
            supportFragmentManager.findFragmentByTag(fragmentType.tag)?.let {
                show(it)
            } ?: run { add(R.id.fcv_container, createFragment(fragmentType), fragmentType.tag) }
        }
    }

    private fun createFragment(fragmentType: FragmentType): Fragment {
        return when (fragmentType) {
            FragmentType.CATEGORY -> CategoryFragment()
            FragmentType.SEARCH -> SearchFragment()
            FragmentType.MAIN -> MainFragment()
            FragmentType.CART -> CartFragment()
            FragmentType.MY_PAGE -> MyPageFragment()
        }
    }
}