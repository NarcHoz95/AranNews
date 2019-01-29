package com.aranteknoloji.arannews

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [AndroidInjectionModule::class, MyModule::class])
interface MyComponent: AndroidInjector<MyApplication>