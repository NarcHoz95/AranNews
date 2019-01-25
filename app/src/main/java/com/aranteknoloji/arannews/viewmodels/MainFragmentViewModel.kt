package com.aranteknoloji.arannews.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.aranteknoloji.arannews.architect.BaseViewModel
import com.aranteknoloji.arannews.architect.Tabs
import com.aranteknoloji.arannews.fragments.FeedsFragment
import com.aranteknoloji.arannews.fragments.SavedFragment
import com.aranteknoloji.arannews.fragments.SettingsFragment

class MainFragmentViewModel : BaseViewModel() {

    val adapter by lazy { MyPagerAdapter() }
    val currentSelectedTab by lazy { MutableLiveData<Int>() }
    val willSelect by lazy { MutableLiveData<Int>() }
    val navItemSelected: (Int) -> Unit = {
        Log.e("MainFragmentViewModel", "CLicked id is $it")
        when (it) {
            Tabs.FEED -> setSelectedTab(0, "Feeds")
            Tabs.SAVED -> setSelectedTab(1, "Saved")
            Tabs.SETTINGS -> setSelectedTab(2, "Settings")
        }
    }
    val viewpageChange: (Int) -> Unit = {
        Log.e("MainFragmentViewModel", "Page chnaged to $it")
        when (it) {
            0 -> willSelect.postValue(Tabs.FEED)
            1 -> willSelect.postValue(Tabs.SAVED)
            2 -> willSelect.postValue(Tabs.SETTINGS)
        }
    }

    private fun setSelectedTab(id: Int, str: String) {
        currentSelectedTab.postValue(id)
        listener?.toolbarTitleChanged(str)
    }

    inner class MyPagerAdapter : FragmentPagerAdapter(provider?.fragmentManager) {

        private val fragments by lazy {
            arrayListOf<Fragment>(FeedsFragment(), SavedFragment(), SettingsFragment())
        }

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = 3
    }
}