package com.example.new_project.view.myPageView.storeView

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.new_project.MainActivity
import com.example.new_project.R
import com.example.new_project.databinding.FragmentCompanyInfoBinding
import com.example.new_project.databinding.FragmentCompanyRegistrationBinding

class companyInfo : Fragment() {
    private var _binding: FragmentCompanyInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var context: Context
    lateinit var mainActivity: MainActivity



    //mainActivity와 연결하기 위한 함수
    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompanyInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //바인딩시 오류났을때 바인딩 초기화
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}