package com.example.new_project.models

//사업자 데이터받는 class
data class companyData(
    var bno: String,
    var cno: String,
    var company: String,
    var BSttCd: String,
    var bstt: String,
    var TaxTypeCd: String,
    var taxtype: String,
    var EndDt: String
)

//사업자 등록번호로 조회한 데이터 받는 class
data class responeBody(
    var resultCode: String,
    var resultMsg: String,
    var totalCount: String,
    var item: List<companyData>
)
