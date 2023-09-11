package com.example.new_project.view.mapView.storeView

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.new_project.MainActivity
import com.example.new_project.databinding.FragmentCompanyRegistrationBinding
import com.example.new_project.models.Global
import com.example.new_project.models.store.StoreDB
import com.example.new_project.models.store.StoreData
import com.example.new_project.util.api.registerApi
import java.lang.Exception
import java.util.Locale

class companyRegistration : Fragment() {
    private var _binding: FragmentCompanyRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var context: Context
    lateinit var mainActivity: MainActivity
    lateinit var company: String
    lateinit var bno: String
    var address = "서울 동작구 상도로67길 32"

    //registerApi와 연결한 변수
    private val registerHelper: registerApi by lazy {
        registerApi.getInstance()
    }

    private val storeHelper: StoreDB by lazy {
        StoreDB.getInstance(mainActivity.applicationContext)
    }

    //mainActivity와 연결하기 위한 함수
    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompanyRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.address.setFocusable(false);

        binding.address.setClickable(false);

        registerClick()
        addressSearch()
    }

    //바인딩시 오류났을때 바인딩 초기화
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //국세청에 사업자등록번호가 등록되었는지 조회하는 함수
    fun registerClick() {
        var code = 0
        bno = binding.register.text.toString()
        binding.btn1.setOnClickListener {
            try {
                code = registerHelper.recievData(binding.register.text.toString())

                when (code) {
                    1 -> {
                        Toast.makeText(mainActivity, "조회완료", Toast.LENGTH_SHORT).show()
                        binding.btn1.isEnabled = false
                        binding.btn1.setText("인증완료")
                    }
                    2 -> Toast.makeText(mainActivity, "조회한 가맹점이 없습니다.", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(mainActivity, "조회에러", Toast.LENGTH_SHORT).show()
                }
                company = Global.company
                //Log.d("Location","lat : ${location.latitude}, lon : ${location.longitude}")
            } catch (e: Exception) {

            }
        }

        binding.btn3.setOnClickListener {
            if(code==1) {
                try {
                    var storeData = StoreData(
                        "", "", address, "{lat: ${location.latitude}, lon: ${location.longitude}}", "테스트2",
                        "00000000", "123123", "1"
                    )
                    storeHelper.insertData(storeData)
                    Toast.makeText(mainActivity, "등록완료59870", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {

                }
            }
            else{
                Toast.makeText(mainActivity, "사업자번호를 인증하지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //
    fun addressSearch() {
        binding.btn2.setOnClickListener {
            try {
                recievAddress(address)
                Global.getAddress(address)
                Global.getLocation(location)
                Toast.makeText(mainActivity, "주소입력완료", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {

            }
        }
    }

    //주소에서 위경도로 변환된 값을 저장하는 변수
    lateinit var location: Location

    //주소를 위경도로 변환하는 함수
    fun recievAddress(address: String) {
        try {
            location = Geocoder(mainActivity.applicationContext, Locale.KOREA).getFromLocationName(
                address,
                1
            )
                ?.let {
                    Location("").apply {
                        latitude = it[0].latitude
                        longitude = it[0].longitude
                    }
                } ?: Location("").apply {
                latitude = 0.0
                longitude = 0.0
            }
        } catch (e: Exception) {
            recievAddress(address)
        }
    }
}