package com.aranteknoloji.arannews

import android.os.Bundle
import com.aranteknoloji.arannews.architect.BaseToolbarActivity
import com.aranteknoloji.arannews.fragments.DenmeFragment

class MainActivity: BaseToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            swapFragment(DenmeFragment())
        }
    }
}