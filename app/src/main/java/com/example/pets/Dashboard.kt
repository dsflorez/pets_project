package com.example.pets

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.example.pets.adapter.PageAdapter
import com.google.firebase.firestore.FirebaseFirestore

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)
        //setUpToolbar()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigation)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val searchFragment = SearchFragment();

        openFragment(searchFragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                val searchFragment = SearchFragment();
                openFragment(searchFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_walker -> {
                val walkerFragment = WalkerFragment();
                openFragment(walkerFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                val profileFragment = ProfileFragment();
                openFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                val searchFragment = SearchFragment();
                openFragment(searchFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun setUpToolbar() {
        // Hide action bar
        val actionBar = supportActionBar
        actionBar!!.hide()
    }


}

