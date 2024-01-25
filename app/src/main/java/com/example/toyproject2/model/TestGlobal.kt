package com.example.toyproject2.model

import com.example.toyproject2.data.local.CategoryItem
import com.example.toyproject2.data.local.DataPage
import com.example.toyproject2.data.local.ProductItem
import com.example.toyproject2.feature.test.category.DetailCategoryType
import com.example.toyproject2.feature.test.category.detail.DetailCategoryFragment

class TestGlobal {

    fun bannerList(): ArrayList<DataPage> {
        val items: ArrayList<DataPage> = ArrayList()
        items.add(DataPage("img1"))
        items.add(DataPage("img2"))
        items.add(DataPage("img3"))
        items.add(DataPage("img4"))
        items.add(DataPage("img5"))
        return items
    }

    fun itemList(): ArrayList<ProductItem> {
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

    fun categoryList(type: DetailCategoryType = DetailCategoryType.A): ArrayList<CategoryItem> {
        val items: ArrayList<CategoryItem> = ArrayList()
        val item1 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "신규입하"
                    else -> "${type}"
                }
            }", "신규입하", "img3"
        )
        val item2 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "발매예약상품"
                    else -> "${type}"
                }
            }", "발매예약상품", "img2"
        )
        val item3 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "상품 분류"
                    else -> "${type}"
                }
            }", "상품 분류", "img1"
        )
        val item4 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "작품별"
                    else -> "${type}"
                }
            }", "작품별", "img2"
        )
        val item5 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "제조사별"
                    else -> "${type}"
                }
            }", "제조사별", "img3"
        )
        val item6 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "굿스마일"
                    else -> "${type}"
                }
            }", "굿스마일", "img4"
        )
        val item7 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "캐릭터굿즈"
                    else -> "${type}"
                }
            }", "캐릭터굿즈", "img5"
        )
        val item8 = CategoryItem(
            "${
                when (type) {
                    DetailCategoryType.A -> "액션피규어"
                    else -> "${type}"
                }
            }", "액션피규어", "img1"
        )
        items.add(item1)
        items.add(item2)
        items.add(item3)
        items.add(item4)
        items.add(item5)
        items.add(item6)
        items.add(item7)
        items.add(item8)
        return items
    }

    fun detailCategoryList(type: DetailCategoryType): ArrayList<CategoryItem> {
        return when (type) {
            DetailCategoryType.A -> categoryList(type)
            DetailCategoryType.B -> categoryList(type)
            DetailCategoryType.C -> categoryList(type)
            DetailCategoryType.D -> categoryList(type)
            DetailCategoryType.E -> categoryList(type)
            DetailCategoryType.F -> categoryList(type)
            DetailCategoryType.G -> categoryList(type)
            DetailCategoryType.H -> categoryList(type)
            DetailCategoryType.I -> categoryList(type)
            DetailCategoryType.J -> categoryList(type)
            DetailCategoryType.K -> categoryList(type)
            DetailCategoryType.L -> categoryList(type)
            DetailCategoryType.M -> categoryList(type)
            DetailCategoryType.N -> categoryList(type)
        }
    }
}