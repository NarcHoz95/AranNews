package com.aranteknoloji.arannews

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.aranteknoloji.arannews.architect.BaseToolbarActivity
import com.aranteknoloji.arannews.fragments.MainFragment

class MainActivity: BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            swapFragment(MainFragment())
        }

        setHomeButtonAction {
            if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStack()
            if (supportFragmentManager.backStackEntryCount == 0) {
                swapFragment(MainFragment())
                disableHomeButton()
            }
        }
    }
}