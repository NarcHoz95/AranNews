package com.aranteknoloji.arannews.architect

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation

@BindingAdapter("onNavigationItemSelected")
fun onNavigationItemSelected(view: BottomNavigationView, func: (Int) -> Unit) {
    view.setOnNavigationItemSelectedListener {
        func.invoke(it.itemId)
        true
    }
}

@BindingAdapter("selectedTab")
fun setSelectedTab(view: BottomNavigationView, @NavMenuItemId id: Int?) {
    id?.let { view.selectedItemId = it }
}

@BindingAdapter("currentSelectedTab")
fun setCurrentSelectedTab(view: ViewPager, id: Int?) {
    id?.let { view.currentItem = it }
}

@BindingAdapter(value = ["onFragmentChange", "onScrollChange"], requireAll = true)
fun setOnFragmentChange(view: ViewPager, func: (Int) -> Unit, func2: (Int, Float) -> Unit) {
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) {
            Log.e("DataBindingAdapter", "state: $state")
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            Log.w("DataBindingAdapter", "position: $position, positionOffset: $positionOffset, and positionOffsetPixels: $positionOffsetPixels")
            func2.invoke(position, positionOffset)
        }

        override fun onPageSelected(position: Int) {
            func.invoke(position)
        }
    })
}

@BindingAdapter(value = ["visibleState", "onState", "offset"], requireAll = true)
fun setVisibleState(view: View, visibleState: Int, state: Int, offset: Float) {
    Log.e("DataBindingAdapter", "offset: ${offset*100}")
    if (visibleState == state) {
        view.animate().translationX(if (offset>.9) offset*100+60 else offset*100)
        view.visibility = View.VISIBLE
    } else if (visibleState != state && offset < .4) view.visibility = View.INVISIBLE
}