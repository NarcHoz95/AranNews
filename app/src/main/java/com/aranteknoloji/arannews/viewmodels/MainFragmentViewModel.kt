package com.aranteknoloji.arannews.viewmodels

import android.support.design.widget.BottomNavigationView
import android.util.Log
import android.view.MenuItem
import com.aranteknoloji.arannews.architect.BaseViewModel
import com.aranteknoloji.arannews.architect.CustomNavCallbacks
import com.aranteknoloji.arannews.architect.Tabs

class MainFragmentViewModel: BaseViewModel() {

    val navCallbacks = object : CustomNavCallbacks {
        override fun tabSelected(id: Int) {
            Log.e("MainFragment", "Tab is clicked, $id")
            Log.e("MainFragment", "Is this saved tab? ${id == Tabs.SAVED}")
        }
    }

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