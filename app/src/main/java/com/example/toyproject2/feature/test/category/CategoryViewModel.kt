package com.example.toyproject2.feature.test.category

import android.app.Application
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject2.R
import com.example.toyproject2.data.local.CategoryItem
import com.example.toyproject2.feature.test.home.FragmentType
import com.example.toyproject2.model.TestGlobal

class CategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val globalHelper: TestGlobal = TestGlobal()

    private val _categoryAdapter: MutableLiveData<CategoryItemAdapter> = MutableLiveData()
    val categoryAdapter: LiveData<CategoryItemAdapter>
        get() = _categoryAdapter

    private val _currentCategoryType: MutableLiveData<DetailCategoryType> =
        MutableLiveData(DetailCategoryType.A)
    val currentCategoryType: LiveData<DetailCategoryType>
        get() = _currentCategoryType

    fun category() {
        val adapter =
            CategoryItemAdapter(context, categoryItems(), CategoryType.BEST, this::service)
        adapter.notifyDataSetChanged()

        _categoryAdapter.value = adapter
    }

    fun setCategoryFragment(item: MenuItem): Boolean {
        val menuItemId = item.itemId
        val pageType = getPageType(menuItemId)
        changeCurrentFragmentType(pageType)

        return true
    }

    private fun getPageType(menuItemId: Int): DetailCategoryType {
        return when (menuItemId) {
            R.id.category_1 -> DetailCategoryType.A
            R.id.category_2 -> DetailCategoryType.B
            R.id.category_3 -> DetailCategoryType.C
            R.id.category_4 -> DetailCategoryType.D
            R.id.category_5 -> DetailCategoryType.E
            R.id.category_6 -> DetailCategoryType.F
            R.id.category_7 -> DetailCategoryType.G
            R.id.category_8 -> DetailCategoryType.H
            R.id.category_9 -> DetailCategoryType.I
            R.id.category_10 -> DetailCategoryType.J
            R.id.category_11 -> DetailCategoryType.K
            R.id.category_12 -> DetailCategoryType.L
            R.id.category_13 -> DetailCategoryType.M
            R.id.category_14 -> DetailCategoryType.N
            else -> throw IllegalArgumentException("Not found menu item")
        }
    }

    private fun changeCurrentFragmentType(categoryType: DetailCategoryType) {
        if (currentCategoryType.value == categoryType) return

        _currentCategoryType.value = categoryType
    }

    fun categoryItems(): ArrayList<CategoryItem> {
        var items = globalHelper.categoryList()
        return items
    }

    fun service(item: CategoryItem) {
        Log.d("category_log", "item: ${item.categoryTitle}")
    }
}