package com.example.toyproject2.feature.test.home.mainHome

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.toyproject2.data.local.DataPage
import com.example.toyproject2.data.local.ProductItem

class MainHomeViewModel: ViewModel() {
    fun imageItems():ArrayList<DataPage>{
        val items: ArrayList<DataPage> = ArrayList()
        items.add(DataPage("img1"))
        items.add(DataPage("img2"))
        items.add(DataPage("img3"))
        items.add(DataPage("img4"))
        items.add(DataPage("img5"))
        return items
    }

    fun bestProduct(): ArrayList<ProductItem>{
        val items: ArrayList<ProductItem> = ArrayList()
        val item1 = ProductItem(
            "item",
            "[24년7월입고] 원피스 메가하우스 룩업 백수의 카이도우&빅맘 (메가토레샵한정) (세트상품,특전포함)",
            11200,
            "예약 마감일: 24년 01월 26일까지",
            "없음",
            true
        )
        val item2 = ProductItem(
            "img1",
            "[입고완료] 미니언즈 가챠 타카라토미 쿵푸 마스코트 피규어 (단품선택) ",
            11200,
            "재고소진시까지",
            "없음",
            true
        )
        val item3 = ProductItem(
            "img2",
            "[입고완료] 나루토 질풍전 반프레스토 VIBRATION STARS 휴우가 히나타2",
            11200,
            "재고소진시까지",
            "없음",
            true
        )
        val item4 = ProductItem(
            "img3",
            "[입고완료] 원피스 반프레스토 월드콜렉터블 피규어 로그스토리즈 몽키D.루피&샹크스",
            11200,
            "예약 마감일: 24년 01월 03일까지",
            "없음",
            true
        )
        val item5 = ProductItem(
            "img4",
            "[입고완료] 귀멸의 칼날 세가 PM 프리미엄 쵸코노세 피규어 코쵸우 시노부(재판)",
            11200,
            "예약 마감일: 24년 01월 26일까지",
            "없음",
            true
        )
        val item6 = ProductItem(
            "img5",
            "[24년6월입고] 짱구는 못말려 반프레스토 봉제인형 훈이,맹구 (단품선택)",
            11200,
            "재료소진시까지",
            "없음",
            true
        )
        items.add(item1)
        items.add(item2)
        items.add(item3)
        items.add(item4)
        items.add(item5)
        items.add(item6)
        return items
    }

    fun service(item: ProductItem){
        Log.d("data", item.title)
    }
}