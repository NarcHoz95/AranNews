package com.aranteknoloji.arannews

import com.aranteknoloji.arannews.architect.BaseActivity
import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {

    fun inject(activiy: BaseActivity)
}