package com.homework.uilistshomework.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.homework.uilistshomework.FragmentContentType
import com.homework.uilistshomework.fragments.MainFragment

class VehiclesPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            FRAGMENT_TAXI_INDEX -> MainFragment(FragmentContentType.TAXI)
            else -> MainFragment(FragmentContentType.CARS_AND_MOTORCYCLES)
        }
    }

    override fun getCount(): Int {
        return FRAGMENT_COUNT
    }

    companion object {
        const val FRAGMENT_COUNT = 2
        const val FRAGMENT_TAXI_INDEX = 0
    }
}