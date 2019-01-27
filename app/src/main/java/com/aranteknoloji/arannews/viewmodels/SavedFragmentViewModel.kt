package com.aranteknoloji.arannews.viewmodels

import com.aranteknoloji.arannews.architect.BaseViewModel
import com.aranteknoloji.arannews.fragments.SettingsFragment

class SavedFragmentViewModel: BaseViewModel() {

    val name = this::class.java.simpleName ?: "B"

    init {
        optionItemSelectedListener {
            addFragment(SettingsFragment())
        }
    }
}