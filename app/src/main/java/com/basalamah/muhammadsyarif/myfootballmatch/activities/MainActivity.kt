package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? =null
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = MatchFragment()
            }
            R.id.navigation_dashboard -> {
                fragment = TeamsFragment()
            }
            R.id.navigation_favorite ->{
                fragment = FavouriteFragment()
            }
        }
        return@OnNavigationItemSelectedListener loadFragment(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(MatchFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            return true
        }
        return false
    }
}
