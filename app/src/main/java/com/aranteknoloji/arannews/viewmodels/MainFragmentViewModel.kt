package com.aranteknoloji.arannews.viewmodels

import android.util.Log
import com.aranteknoloji.arannews.architect.BaseViewModel

class MainFragmentViewModel: BaseViewModel() {

    val navItemSelected: (Int) -> Unit = {
        Log.e("MainFragmentViewModel", "CLicked id is ${it}")
    }
}