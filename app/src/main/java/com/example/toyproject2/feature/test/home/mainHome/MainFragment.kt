package com.example.toyproject2.feature.test.home.mainHome

import android.content.ContextParams
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.throw_fornt.util.common.BindingFragment
import com.example.toyproject2.R
import com.example.toyproject2.databinding.FragmentMainBinding

class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val viewModel: MainHomeViewModel by viewModels()
    private lateinit var sliderViewPage: ViewPager2;
    private lateinit var layout: LinearLayout;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        sliderViewPage = view.findViewById(R.id.sliderViewPager)
        layout = view.findViewById(R.id.layoutIndicators)

        slider()
        viewModel.bestProduct()
        viewModel.newProduct()
        viewModel.reservationProduct()
    }

    fun slider() {

        val items = viewModel.testImageItems();

        sliderViewPage.offscreenPageLimit = 1;
        sliderViewPage.adapter = ImageSliderAdapter(requireContext(), items);

        var currentPage = 0
        val handler = Handler()

        val update = Runnable {
            if (currentPage == items.size) {
                currentPage = 0
            }
            sliderViewPage.setCurrentItem(currentPage++, true)
        }

        val delay: Long = 3000
        handler.postDelayed(object : Runnable {
            override fun run() {
                update.run()
                handler.postDelayed(this, delay)
            }
        }, delay)

        sliderViewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        setupIndicators(items.size)
    }

    private fun setupIndicators(count: Int) {
        val indicators = arrayOfNulls<ImageView>(count)
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.setMargins(16, 8, 16, 8)

        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext())
            indicators[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_indicator_inactive
                )
            )
            indicators[i]?.layoutParams = params
            layout.addView(indicators[i])
        }
        setCurrentIndicator(0)
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = layout.childCount
        for (i in 0 until childCount) {
            val imageView = layout.getChildAt(i) as? ImageView
            if (i == position) {
                imageView?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.bg_indicator_active
                    )
                )
            } else {
                imageView?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.bg_indicator_inactive
                    )
                )
            }
        }
    }
}