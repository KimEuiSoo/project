package com.example.toyproject2.feature.test.category

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyproject2.data.local.CategoryItem
import com.example.toyproject2.model.TestGlobal

class CategoryViewModel(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val globalHelper: TestGlobal = TestGlobal()

    private val _categoryAdapter: MutableLiveData<CategoryItemAdapter> = MutableLiveData()
    val categoryAdapter: LiveData<CategoryItemAdapter>
        get() = _categoryAdapter

//    private val _categoryLayoutManager: MutableLiveData<LinearLayoutManager> = MutableLiveData()
//    val categoryLayoutManager: LiveData<LinearLayoutManager>
//        get() = _categoryLayoutManager

    fun category(){
        val adapter = CategoryItemAdapter(context, categoryItems(), CategoryType.BEST, this::service)
//        _categoryLayoutManager.value = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter.notifyDataSetChanged()

        _categoryAdapter.value = adapter
    }

    fun categoryItems(): ArrayList<CategoryItem>{
        var items = globalHelper.categoryList()
        return items
    }

    fun service(item: CategoryItem){
        Log.d("category_log", "item: ${item.categoryTitle}")
    }
}