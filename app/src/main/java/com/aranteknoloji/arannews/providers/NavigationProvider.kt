package com.aranteknoloji.arannews.providers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.aranteknoloji.arannews.R
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject

class NavigationProvider @Inject constructor(val fragmentManager: FragmentManager) {

    fun swapFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }
}