package com.aranteknoloji.arannews.architect

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.aranteknoloji.arannews.R

/**
 * BaseFragment extends with Fragment. Moreover, it provides viewModel and
 * fragment transaction functions in order to get best user experience.
 * If you want to change the Toolbar, make sure your viewModel has AranToolbar class.
 *
 * @param classOfVM is for setting your preferred viewModel class
 * @param generic is stands for the instance of your created viewModel class
 *
 * @see AranToolbar */
abstract class BaseFragment<T: ViewModel>(classOfVM: Class<T>): Fragment() {

    /**
     * It is a created ViewModel class by BaseFragment.
     * You can assign directly to your data binding structure, or
     * use it how you wish
     *
     * @see ViewModel*/
    val viewModel by lazy { ViewModelProviders.of(this).get(classOfVM) }

    /**
     * This replaces the fragment with the new instance which you passed as param
     *
     * @param fragment the new instance of swaped fragment*/
    fun swapFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_frame, fragment)?.commit()
    }

    /**
     * This adds the fragment to top of the stack.
     * The param fragment would be the top visible fragment that user can see
     *
     * @param fragment the instance of the new fragment*/
    fun addFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_frame, fragment)?.addToBackStack(fragment.tag)?.commit()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (viewModel is BaseViewModel) {
            (viewModel as BaseViewModel).listener = context as AranToolbar
        }
    }

    override fun onDetach() {
        super.onDetach()
        if (viewModel is BaseViewModel) {
            (viewModel as BaseViewModel).listener = null
        }
    }
}

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun swapFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }
}

abstract class BaseToolbarMenuActivity: BaseActivity(), AranToolbar {

    val toolbar by lazy { findViewById<Toolbar>(R.id.main_toolbar) }
    var actionCreateMenu: (menu: Menu?) -> Boolean = { false }
    var actionSettingsItem: () -> Boolean = { false }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return actionCreateMenu.invoke(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return actionSettingsItem.takeIf { item?.itemId == MenuItems.SETTINGS.id }?.invoke() ?: false
    }

    fun enableHomeButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setHomeButtonAction(func: () -> Unit) {
        toolbar.setNavigationOnClickListener { func.invoke() }
    }
}

abstract class BaseViewModel: ViewModel() {

    var listener: AranToolbar? = null
}

enum class MenuItems(val id: Int){
    SETTINGS(R.id.action_settings),
    DEFAULT(0)
}

interface AranToolbar {

    fun toolbarTitleChanged(str: String)
}