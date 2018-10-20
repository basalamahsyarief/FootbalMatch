package com.basalamah.muhammadsyarif.myfootballmatch.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class AllViewPagerAdapter(fragment: FragmentManager):FragmentPagerAdapter(fragment) {
    val fragments = arrayListOf<Fragment>()
    val titles = arrayListOf<String>()
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
    fun addFragment(fragment: Fragment,title:String){
        fragments.add(fragment)
        titles.add(title)
    }
}