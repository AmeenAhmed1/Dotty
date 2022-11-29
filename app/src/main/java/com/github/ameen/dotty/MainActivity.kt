package com.github.ameen.dotty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.github.ameen.dotty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    val binding
        get() = _binding

    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        inflateIntroAdapter()
    }

    private fun inflateIntroAdapter() {

        val adapter = SliderAdapter(this)
        binding.viewPager.adapter = adapter

        fragmentList.addAll(
            listOf(
                FragmentTest(),
                FragmentTest(),
                FragmentTest(),
                FragmentTest()
            )
        )

        adapter.setFragmentList(fragmentList)

        binding.dotty.setIndicatorCount(adapter.itemCount)
        handleSwipes()
    }

    private fun handleSwipes() {
        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                binding.dotty.selectCurrentPosition(position)
            }
        })
    }
}