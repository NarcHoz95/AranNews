package com.aranteknoloji.arannews

import android.support.v4.app.FragmentActivity
import com.aranteknoloji.arannews.providers.NavigationProvider
import dagger.Module
import dagger.Provides

@Module
class MyModule(val fragmentActivity: FragmentActivity) {

    @Provides
    fun providesNavigationProvider() = NavigationProvider(fragmentActivity.supportFragmentManager)
}