package com.aranteknoloji.arannews.architect

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(view: BottomNavigationView, listener: CustomNavCallbacks) {
    view.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            Log.e("DataBindingAdapter", "navigation item: ${item.itemId}")
            listener.tabSelected(item.itemId)
            return true
        }
    })
}

@FunctionalInterface
interface CustomNavCallbacks {

    fun tabSelected(@NavMenuItemId id: Int)
}
