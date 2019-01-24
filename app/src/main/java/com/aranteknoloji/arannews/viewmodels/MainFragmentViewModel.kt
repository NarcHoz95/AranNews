package com.aranteknoloji.arannews.viewmodels

import android.databinding.BindingAdapter
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem
import com.aranteknoloji.arannews.architect.BaseViewModel

class MainFragmentViewModel: BaseViewModel() {

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.e("MainFragmentViewModel", "onNavigationItemSelected")
//        return false
//    }
//
//    fun onNavigationClick(@NonNull item: MenuItem): Boolean {
//        Log.e("MainFragmentViewModel", "onNavigationClick")
//        return false
//    }android:navigationItemSelected="@{() -> viewmodel.navItemSelectedLamda}"


    val navlis = object:BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            Log.e("MainFragmentViewModel", "CLicked id is ${item.itemId}")
            return true
        }
    }

    val navItemSelectedLamda: (MenuItem) -> Unit = {
        Log.e("MainFragmentViewModel", "CLicked id is ${it.itemId}")
    }

    fun tabSelected(i: Int) {
        Log.e("MainFragmentViewModel", "CLicked id is $i")
    }

//    @BindingAdapter("android:navigationItemSelected")
//    fun setOnNavigationItemSelectedListener(view: BottomNavigationView, func: (MenuItem) -> Unit) {
//        view.setOnNavigationItemSelectedListener{
//            func.invoke(it)
//            true
//        }
//    }
}