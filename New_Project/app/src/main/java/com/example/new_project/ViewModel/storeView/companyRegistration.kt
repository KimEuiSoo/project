package com.example.new_project.ViewModel.mapView.storeView

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.new_project.MainActivity
import com.example.new_project.R
import com.example.new_project.databinding.FragmentCompanyRegistrationBinding
import com.example.new_project.util.registerApi
import java.lang.Exception
import java.util.Locale

class companyRegistration : Fragment() {
    private var _binding: FragmentCompanyRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var context: Context
    lateinit var mainActivity: MainActivity

    private val registerHelper: registerApi by lazy {
        registerApi.getInstance()
    }

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

        registerClick()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun registerClick() {
        binding.btn1.setOnClickListener {
            try {
                /*var code = 0
                code = registerHelper.recievData(binding.register.text.toString())
                when (code) {
                    1 -> Toast.makeText(mainActivity, "조회완료", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(mainActivity, "조회한 가맹점이 없습니다.", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(mainActivity, "조회에러", Toast.LENGTH_SHORT).show()
                }*/
                recievAddress(binding.address.text.toString())
                Log.d("Location","lat : ${location.latitude}, lon : ${location.longitude}")
            } catch (e: Exception) {

            }
        }
    }

    lateinit var location: Location
    fun recievAddress(address: String) {
        try {
            location=Geocoder(mainActivity.applicationContext, Locale.KOREA).getFromLocationName(address, 1)
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