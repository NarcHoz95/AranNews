package com.aranteknoloji.arannews.architect

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.aranteknoloji.arannews.R

/**
 * BaseFragment extends with Fragment. Moreover, it provides viewModel and
 * fragment transaction functions in order to get best user experience.
 * If you want to change the Toolbar, make sure your viewModel has AranToolbar class.
 *
 * @param classOfVM is for setting your preferred viewModel class
 * @param T is stands for the instance of your created viewModel class
 *
 * @see AranToolbar */
abstract class BaseFragment<T: BaseViewModel>(classOfVM: Class<T>): Fragment() {

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
        activity?.let { try { (it as BaseToolbarActivity).enableHomeButton() } catch (e: TypeCastException) { e.printStackTrace() } }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel.listener = context as AranToolbar
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.listener = null
    }
}

abstract class BaseMenuFragment<T: BaseViewModel>(classOfVM: Class<T>): BaseFragment<T>(classOfVM) {

    var menuRes: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menuRes?.let {
            inflater?.inflate(it, menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            viewModel.optionItemSelected.invoke(it.itemId)
        }
        return super.onOptionsItemSelected(item)
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

abstract class BaseToolbarActivity: BaseActivity(), AranToolbar {

    private val toolbar by lazy { findViewById<Toolbar>(R.id.main_toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
    }

    override fun toolbarTitleChanged(str: String) {
        toolbar.title = str
    }

    fun enableHomeButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setHomeButtonAction(func: () -> Unit) {
        toolbar.setNavigationOnClickListener { func.invoke() }
    }
}

abstract class BaseViewModel: ViewModel() {

    /**
     * listener is lamda function that can be invoked when toolbar title
     * needs to be changed.
     *
     * @see AranToolbar*/
    var listener: AranToolbar? = null

    /**
     * If you are using BaseMenuFragment in your fragment which belongs to that viewModel,
     * you may wanna use this listener as your action item.
     * You will have the id of the clicked item in the menu.
     * Finally, you need to return boolean whether to see your action is completed or not.
     * If it is <var>true</var>, your action would be completed. If it is false, your action would not
     * be completed.</br>
     * We will suggest you to use Enum class in order to get action ids of the menu items.
     *
     * @see Enum
     * @see BaseMenuFragment
     * @see optionItemSelectedListener*/
    var optionItemSelected: (Int) -> Unit = {  }

    fun optionItemSelectedListener(func: (Int) -> Unit) {optionItemSelected = func}
}

enum class Menus(val id: Int) {
    MAIN(R.menu.main)
}

interface AranToolbar {

    fun toolbarTitleChanged(str: String)
}