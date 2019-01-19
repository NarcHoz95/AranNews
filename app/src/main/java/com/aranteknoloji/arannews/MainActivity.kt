package com.aranteknoloji.arannews

import android.os.Bundle
import android.widget.Toast
import com.aranteknoloji.arannews.architect.BaseToolbarActivity
import com.aranteknoloji.arannews.architect.Menus
import com.aranteknoloji.arannews.fragments.DenmeFragment

class MainActivity: BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            swapFragment(DenmeFragment())
        }

        testingStuff()
    }

    fun testingStuff() {
        enableHomeButton()

        setHomeButtonAction {
            Toast.makeText(this, supportFragmentManager.backStackEntryCount.toString(), Toast.LENGTH_SHORT).show()
        }

//        actionCreateMenu = {
//            inflateMenu(Menus.MAIN, it)
//            true
//        }
//
//        actionSettingsItem = {
//            Toast.makeText(this, "Settings Act", Toast.LENGTH_SHORT).show()
//            true
//        }
    }
}