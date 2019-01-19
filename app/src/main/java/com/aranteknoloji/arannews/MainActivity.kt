package com.aranteknoloji.arannews

import android.os.Bundle
import android.widget.Toast
import com.aranteknoloji.arannews.architect.BaseActivity
import com.aranteknoloji.arannews.architect.BaseToolbarMenuActivity
import com.aranteknoloji.arannews.fragments.DenmeFragment

class MainActivity: BaseToolbarMenuActivity() {

    override fun toolbarTitleChanged(str: String) {
        toolbar.title = str
    }

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

        actionCreateMenu = {
            menuInflater.inflate(R.menu.main, it)
            true
        }

        actionSettingsItem = {
            Toast.makeText(this, "Settings Act", Toast.LENGTH_SHORT).show()
            true
        }
    }
}