package com.example.new_project.models

import com.google.gson.annotations.SerializedName

//사업자 데이터받는 class
data class companyData(
    @SerializedName("bno")val bno: String,
    @SerializedName("cno")val cno: String,
    @SerializedName("company")val company: String,
    @SerializedName("BSttCd")val BSttCd: String,
    @SerializedName("bstt")val bstt: String,
    @SerializedName("TaxTypeCd")val TaxTypeCd: String,
    @SerializedName("taxtype")val taxtype: String,
    @SerializedName("EndDt")val EndDt: String
){
    override fun toString(): String {
        return "companyData : [\n" +
                "   bno : ${bno}\n" +
                "   cno : ${cno}\n" +
                "   company : ${company}\n" +
                "   BSttCd : ${BSttCd}\n" +
                "   bstt : ${bstt}\n" +
                "   TaxTypeCd : ${TaxTypeCd}\n" +
                "   taxtype : ${taxtype}\n" +
                "   EndDt : ${EndDt}\n"
    }
}

//사업자 등록번호로 조회한 데이터 받는 class
data class responeBody(
    @SerializedName("resultCode")var resultCode: String,
    @SerializedName("resultMsg")var resultMsg: String,
    @SerializedName("totalCount")var totalCount: String,
    @SerializedName("item")var item: List<companyData>
){
    override fun toString(): String {
        return "$item\n\n" +
                "resultCode: $resultCode\n" +
                "resultMsg: $resultMsg\n" +
                "totalCount: $totalCount"
    }
}
