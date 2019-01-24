package com.aranteknoloji.arannews.architect

import android.support.annotation.IntDef
import com.aranteknoloji.arannews.R

const val FEED = R.id.nav_action_feed
const val SAVED = R.id.nav_action_saved
const val SETTINGS = R.id.nav_action_settings

@IntDef(FEED, SAVED, SETTINGS)
@Retention(AnnotationRetention.SOURCE)
annotation class NavMenuItemId