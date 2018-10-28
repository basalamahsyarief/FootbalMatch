package com.basalamah.muhammadsyarif.myfootballmatch.fragments
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.basalamah.muhammadsyarif.myfootballmatch.R
import com.basalamah.muhammadsyarif.myfootballmatch.adapters.AllViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_match.*

class FavouriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AllViewPagerAdapter(childFragmentManager)
        adapter.addFragment(FavouriteEventFragment(),"Events")
        adapter.addFragment(FavouriteTeamFragment(),"Teams")
        main_content_match.adapter = adapter
        tabs.setupWithViewPager(main_content_match)
    }
}
