package com.homework.uilistshomework.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.homework.uilistshomework.FragmentContentType
import com.homework.uilistshomework.fragments.MainFragment

class VehiclesPagerAdapter(private val fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment = Fragment()
        when (position) {
            0 -> fragment = MainFragment(FragmentContentType.TAXI)
            1 -> fragment = MainFragment(FragmentContentType.CARS_AND_MOTORCYCLES)
        }
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }
}