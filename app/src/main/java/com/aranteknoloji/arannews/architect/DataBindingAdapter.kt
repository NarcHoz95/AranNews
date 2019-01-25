package com.aranteknoloji.arannews.architect

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(view: BottomNavigationView, func: (Int) -> Unit) {
    view.setOnNavigationItemSelectedListener {
        func.invoke(it.itemId)
        true
    }
}

@BindingAdapter("selectedTab")
fun setSelectedTab(view: BottomNavigationView, id: Int?) {
    id?.let { view.selectedItemId = it }
}

@BindingAdapter("currentSelectedTab")
fun setCurrentSelectedTab(view: ViewPager, id: Int?) {
    id?.let { view.currentItem = it }
}

@BindingAdapter("onFragmentChange")
fun setOnFragmentChange(view: ViewPager, func: (Int) -> Unit) {
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            func.invoke(position)
        }
    })
}