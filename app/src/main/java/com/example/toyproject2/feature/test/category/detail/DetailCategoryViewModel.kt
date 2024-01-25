package com.example.toyproject2.feature.test.category.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toyproject2.data.local.CategoryItem
import com.example.toyproject2.feature.test.category.CategoryItemAdapter
import com.example.toyproject2.feature.test.category.CategoryType

class DetailCategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    private lateinit var items: ArrayList<CategoryItem>

    private val _categoryAdapter: MutableLiveData<CategoryItemAdapter> = MutableLiveData()
    val categoryAdapter: LiveData<CategoryItemAdapter>
        get() = _categoryAdapter

    fun dataReceive(categoryItems: ArrayList<CategoryItem>) {
        items = categoryItems
        category()
    }

    fun category() {
        val adapter = CategoryItemAdapter(context, items, CategoryType.BEST, this::service)
        adapter.notifyDataSetChanged()

        _categoryAdapter.value = adapter
    }

    fun service(item: CategoryItem) {
        Log.d("category_log", "item: ${item.title}")
    }
}