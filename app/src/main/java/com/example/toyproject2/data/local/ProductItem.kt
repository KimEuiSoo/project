package com.example.toyproject2.data.local

data class ProductItem(
    val image: String,
    val title: String, // 상품 제목
    val account: Int, // 가격
    val deadline: String, // 마감일
    val content: String,
    val status: Boolean,    //매진상태
)
