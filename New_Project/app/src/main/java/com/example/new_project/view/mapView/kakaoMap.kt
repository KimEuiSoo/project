package com.example.new_project.view.mapView.mapView

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.new_project.MainActivity
import com.example.new_project.databinding.FragmentKakaoMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class kakaoMap : Fragment() {
    //fragement_kakao_map.xml 바인딩하기 위한 변수ㅠ
    private var _binding: FragmentKakaoMapBinding? = null
    private val binding get() = _binding!!
    //카카오 맵을 저장하는 함수
    private lateinit var mapView: MapView
    //현재 위치를 저장한 변수
    lateinit var mLastLocation: Location
    //맵 위치 정보를 요청하는 변수
    internal lateinit var mLocationRequest: LocationRequest
    //현재 위치를 가져오기 위한 변수
    private var mFusedLocationProviderClient: FusedLocationProviderClient? = null
    //activity객체를 사용하기 위한 변수
    lateinit var mainActivity: MainActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

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

        mLocationRequest =  LocationRequest.create().apply {

            priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        }

        mapView = MapView(context)
        var mapViewContainer: ViewGroup = binding.maps
        mapViewContainer.addView(mapView)
        currentLocation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun currentLocation(){
        //mFusedLocationProviderClient인스턴스를 생성
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mainActivity)
        //기기의 권환 확인
        if (ActivityCompat.checkSelfPermission(mainActivity.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(mainActivity.applicationContext,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        mFusedLocationProviderClient!!.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper())
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            // 시스템에서 받은 location 정보를 onLocationChanged()에 전달
            locationResult.lastLocation
            mLastLocation = locationResult.lastLocation!!
            mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(mLastLocation.latitude, mLastLocation.longitude), 1, true)
        }
    }

}