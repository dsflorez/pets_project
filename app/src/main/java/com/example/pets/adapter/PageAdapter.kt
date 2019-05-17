package com.example.pets.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.pets.ProfileFragment
import com.example.pets.SearchFragment
import com.example.pets.WalkerFragment

class PageAdapter(fm: FragmentManager?, val numTaps: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> return SearchFragment()
            1 -> return WalkerFragment()
            2 -> return ProfileFragment()
            else -> return SearchFragment()
        }
    }

    override fun getCount(): Int {
        return numTaps
    }
}