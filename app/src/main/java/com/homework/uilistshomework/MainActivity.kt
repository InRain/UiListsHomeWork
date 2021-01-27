package com.homework.uilistshomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.adapters.VehiclesPagerAdapter
import com.homework.uilistshomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tabLayout.addTab(tabLayout.newTab().setText(resources.getString(R.string.taxi)))
            tabLayout.addTab(
                tabLayout.newTab().setText(resources.getString(R.string.cars_and_motorcycles))
            )
            tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        }

        val pagerAdapter = VehiclesPagerAdapter(supportFragmentManager)
        binding.viewpager.adapter = pagerAdapter

        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewpager.currentItem = tab?.position!!
            }
        })

    }
}
