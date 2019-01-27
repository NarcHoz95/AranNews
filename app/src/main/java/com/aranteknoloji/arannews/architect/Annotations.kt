package com.aranteknoloji.arannews.architect

import android.support.annotation.IntDef
import android.support.annotation.StringDef
import com.aranteknoloji.arannews.R

object Tabs {
    const val FEED = R.id.nav_action_feed
    const val SAVED = R.id.nav_action_saved
    const val SETTINGS = R.id.nav_action_settings

    const val FEEDS_TITLE: String = "Feeds"
    const val SAVED_TITLE: String = "Saved"
    const val SETTINGS_TITLE: String = "Settings"
}
@IntDef(Tabs.FEED, Tabs.SAVED, Tabs.SETTINGS)
@Retention(AnnotationRetention.SOURCE)
annotation class NavMenuItemId

@StringDef(Tabs.FEEDS_TITLE, Tabs.SAVED_TITLE, Tabs.SETTINGS_TITLE)
@Retention(AnnotationRetention.SOURCE)
annotation class NavMenuTitle


object Menus {
    const val MAIN = R.menu.main
    const val BOTTOM_NAV = R.id.bottom_nav
}
@IntDef(Menus.MAIN, Menus.BOTTOM_NAV)
@Retention(AnnotationRetention.SOURCE)
annotation class ToolbarMenus