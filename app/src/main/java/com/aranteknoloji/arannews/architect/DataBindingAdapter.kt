package com.aranteknoloji.arannews.architect

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(view: BottomNavigationView, func: (Int) -> Unit) {
    view.setOnNavigationItemSelectedListener {
        func.invoke(it.itemId)
        true
    }
}
