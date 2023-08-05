package com.example.new_project.ViewModel.mapView.storeView

import android.content.Context
import android.os.Bundle
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

class companyRegistration : Fragment() {
    private var _binding : FragmentCompanyRegistrationBinding? = null
    private val binding get() = _binding!!
    private lateinit var context: Context
    lateinit var mainActivity: MainActivity

    private val registerHelper: registerApi by lazy{
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

    fun registerClick(){
        binding.btn1.setOnClickListener {
            try{
                var code = 0
                code = registerHelper.recievData(binding.register.text.toString())
                when(code){
                    1 -> Toast.makeText(mainActivity, "조회완료", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(mainActivity, "조회한 가맹점이 없습니다.", Toast.LENGTH_SHORT).show()
                    else-> Toast.makeText(mainActivity, "조회에러", Toast.LENGTH_SHORT).show()
                }

            }
            catch (e: Exception){

            }
        }
    }
}