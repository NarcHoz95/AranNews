package com.aranteknoloji.arannews

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyModule {

    @ContributesAndroidInjector
    abstract fun contributesAndroidInjector(): MainActivity
}