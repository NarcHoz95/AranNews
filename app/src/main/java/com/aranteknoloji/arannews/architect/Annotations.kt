package com.aranteknoloji.arannews.architect

import android.support.annotation.IntDef
import com.aranteknoloji.arannews.R

object Tabs {
    const val FEED = R.id.nav_action_feed
    const val SAVED = R.id.nav_action_saved
    const val SETTINGS = R.id.nav_action_settings
}
@IntDef(Tabs.FEED, Tabs.SAVED, Tabs.SETTINGS)
@Retention(AnnotationRetention.SOURCE)
annotation class NavMenuItemId


object Menus {
    const val MAIN = R.menu.main
    const val BOTTOM_NAV = R.id.bottom_nav
}
@IntDef(Menus.MAIN, Menus.BOTTOM_NAV)
@Retention(AnnotationRetention.SOURCE)
annotation class ToolbarMenus