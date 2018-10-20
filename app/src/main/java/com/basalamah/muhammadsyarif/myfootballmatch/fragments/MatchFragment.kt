package com.basalamah.muhammadsyarif.myfootballmatch.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.AllViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment() {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AllViewPagerAdapter(childFragmentManager)

        setHasOptionsMenu(true)
        adapter.addFragment(NextFragment(),"Next Match")
        adapter.addFragment(PastFragment(),"Past Match")
        main_content_match.adapter = adapter
        tabs.setupWithViewPager(main_content_match)

    }
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return when (position){
                0 -> NextFragment()
                else -> {
                    PastFragment()
                }
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }
    }

}
