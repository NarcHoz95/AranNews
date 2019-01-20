package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.R
import com.aranteknoloji.arannews.architect.BaseToolbarActivity

class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val navigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_action_feed -> swapFragment(DenmeFragment())
                R.id.nav_action_saved -> swapFragment(DenmeFragment())
                R.id.nav_action_settings -> swapFragment(DenmeFragment())
                else -> false
            }
        }
        if (savedInstanceState == null) {
            swapFragment(DenmeFragment())
        }
        return view
    }

    private fun swapFragment(fragment: Fragment): Boolean {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_frame, fragment)?.commit()
        return true
    }
}