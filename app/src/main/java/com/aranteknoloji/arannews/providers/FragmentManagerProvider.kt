package com.aranteknoloji.arannews.providers

import android.support.v4.app.FragmentActivity

class FragmentManagerProvider(val activity: FragmentActivity) {

    val fragmentManager by lazy { activity.supportFragmentManager }
}