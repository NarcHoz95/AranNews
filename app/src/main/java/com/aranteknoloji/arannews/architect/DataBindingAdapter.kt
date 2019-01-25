package com.aranteknoloji.arannews.architect

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(view: BottomNavigationView, listener: CustomNavCallbacks) {
    view.setOnNavigationItemSelectedListener {
        listener.tabSelected(it.itemId)
        true
    }
}

interface CustomNavCallbacks {

    fun tabSelected(@NavMenuItemId id: Int)
}
