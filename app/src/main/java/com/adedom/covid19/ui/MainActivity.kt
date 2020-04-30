package com.adedom.covid19.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.adedom.covid19.R
import com.adedom.covid19.ui.cases.CasesFragment
import com.adedom.covid19.ui.sum.SumFragment
import com.adedom.covid19.ui.timeline.TimelineFragment
import com.adedom.covid19.ui.today.TodayFragment
import com.adedom.covid19.util.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_view.setOnNavigationItemSelectedListener(this)
        if (savedInstanceState == null) replaceFragment(TodayFragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_today -> replaceFragment(TodayFragment())
            R.id.nav_timeline -> replaceFragment(TimelineFragment())
            R.id.nav_cases -> replaceFragment(CasesFragment())
            R.id.nav_sum -> replaceFragment(SumFragment())
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment) = supportFragmentManager.beginTransaction()
        .replace(R.id.frame_layout, fragment)
        .commit()

}
