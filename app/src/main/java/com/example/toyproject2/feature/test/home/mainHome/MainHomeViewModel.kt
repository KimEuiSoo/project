package com.example.toyproject2.feature.test.home.mainHome

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.toyproject2.data.local.DataPage
import com.example.toyproject2.data.local.ProductItem
import com.example.toyproject2.model.TestGlobal

class MainHomeViewModel(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val globalHelper: TestGlobal = TestGlobal()

    private val _bRecyclerView: MutableLiveData<ProductItemAdapter> = MutableLiveData()
    val bRecyclerView: LiveData<ProductItemAdapter>
        get() = _bRecyclerView

    private val _bLayoutManager: MutableLiveData<LayoutManager> = MutableLiveData()
    val bLayoutManager: LiveData<LayoutManager>
        get() = _bLayoutManager
    private val _nRecyclerView: MutableLiveData<ProductItemAdapter> = MutableLiveData()
    val nRecyclerView: LiveData<ProductItemAdapter>
        get() = _nRecyclerView

    private val _nLayoutManager: MutableLiveData<GridLayoutManager> = MutableLiveData()
    val nLayoutManager: LiveData<GridLayoutManager>
        get() = _nLayoutManager

    private val _rRecyclerView: MutableLiveData<ProductItemAdapter> = MutableLiveData()
    val rRecyclerView: LiveData<ProductItemAdapter>
        get() = _rRecyclerView

    private val _rLayoutManager: MutableLiveData<GridLayoutManager> = MutableLiveData()
    val rLayoutManager: LiveData<GridLayoutManager>
        get() = _rLayoutManager

    fun bestProduct(){
        val adapter = ProductItemAdapter(context, testBestProduct(), ProductType.BEST,this::service)
        _bLayoutManager.value = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter.notifyDataSetChanged()

        _bRecyclerView.value = adapter
    }

    fun newProduct(){
        val adapter = ProductItemAdapter(context, testBestProduct(), ProductType.NEW, this::service)
        _nLayoutManager.value = GridLayoutManager(context, 2)
        adapter.notifyDataSetChanged()

        _nRecyclerView.value = adapter
    }

    fun reservationProduct(){
        val adapter = ProductItemAdapter(context, testBestProduct(), ProductType.NEW, this::service)
        _rLayoutManager.value = GridLayoutManager(context, 2)
        adapter.notifyDataSetChanged()

        _rRecyclerView.value = adapter
    }


    //TODO 테스트 배너 이미지
    fun testImageItems():ArrayList<DataPage>{
        var items: ArrayList<DataPage> = ArrayList()
        items = globalHelper.bannerList()
        return items
    }

    //TODO 테스트 베스트 상품 이미지
    fun testBestProduct(): ArrayList<ProductItem>{
        var items: ArrayList<ProductItem> = ArrayList()
        items = globalHelper.itemList()
        return items
    }

    fun service(item: ProductItem, type: String){
        if(type.equals("favorite"))
            Log.d("data", "favorite item : ${item.title}")
        else
            Log.d("data", "item : ${item.title}")
    }
}