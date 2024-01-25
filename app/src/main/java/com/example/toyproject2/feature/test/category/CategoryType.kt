package com.example.toyproject2.feature.test.category

enum class CategoryType(val tag: String) {
    BEST("best_tag"),
    NORMAL("normal_tag")
}

enum class DetailCategoryType(val tag: String) {
    A("a_tag"),     //ㄱ 카테고리
    B("b_tag"),     //ㄴ 카테고리
    C("c_tag"),     //ㄷ 카테고리
    D("c_tag"),     //ㄹ 카테고리
    E("c_tag"),     //ㅁ 카테고리
    F("c_tag"),     //ㅂ 카테고리
    G("c_tag"),     //ㅅ 카테고리
    H("c_tag"),     //ㅇ 카테고리
    I("c_tag"),     //ㅈ 카테고리
    J("c_tag"),     //ㅊ 카테고리
    K("c_tag"),     //ㅋ 카테고리
    L("c_tag"),     //ㅌ 카테고리
    M("c_tag"),     //ㅍ 카테고리
    N("c_tag"),     //ㅎ 카테고리
}

data class DetailCategoryItem(
    val item: DetailCategoryType,
    val isSelected: Boolean,
);