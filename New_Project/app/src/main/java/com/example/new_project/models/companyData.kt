package com.example.new_project.models

import com.google.gson.annotations.SerializedName

//사업자 데이터받는 class
data class companyData(
    val bno: String,        //사업자등록번호
    val cno: String,        //법인등록번호
    val company: String,    //회사명
    val BSttCd: String,     //사업자상태(코드)
    val bstt: String,       //사업자상태(명칭)
    val TaxTypeCd: String,  //과세유형(코드)
    val taxtype: String,    //과세유형(명칭)
    val EndDt: String       //폐업일
)

//사업자 등록번호로 조회한 데이터 받는 class
data class responeBody(
    @SerializedName("resultCode")var resultCode: String,        //결과코드
    @SerializedName("resultMsg")var resultMsg: String,          //결과메세지
    @SerializedName("totalCount")var totalCount: String,        //총 아이템 갯수
    @SerializedName("items")var items: List<companyData>        //가게 리스트
){
    override fun toString(): String {
        return "$items\n\n" +
                "resultCode: $resultCode\n" +
                "resultMsg: $resultMsg\n" +
                "totalCount: $totalCount"
    }
}
