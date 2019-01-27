package com.aranteknoloji.arannews.providers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.aranteknoloji.arannews.R

class FragmentManagerProvider(val activity: FragmentActivity) {

    private val fragments by lazy { arrayListOf<Fragment>() }
    val fragmentManager by lazy { activity.supportFragmentManager }

    fun swapFragment(fragment: Fragment) {
        fragments.add(fragment)
        fragmentManager.beginTransaction()
            .replace(R.id.main_frame, fragment, fragment.tag)
            .commit()
    }

    fun parentFragment(): Fragment? {
        return if (fragments.size > 0) fragments[fragments.size - 1] else null
    }
}