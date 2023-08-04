package com.example.new_project.ViewModel.mapView.mapView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.new_project.databinding.FragmentKakaoMapBinding
import net.daum.mf.map.api.MapView

class kakaoMap : Fragment() {
    private var _binding: FragmentKakaoMapBinding? = null
    private val binding get() = _binding!!
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKakaoMapBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = MapView(context)
        var mapViewContainer: ViewGroup = binding.maps
        mapViewContainer.addView(mapView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}