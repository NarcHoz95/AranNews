package com.aranteknoloji.arannews.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.R
import com.aranteknoloji.arannews.architect.*
import com.aranteknoloji.arannews.databinding.FragmentMainBinding
import com.aranteknoloji.arannews.viewmodels.MainFragmentViewModel

class MainFragment: BaseFragment<MainFragmentViewModel>(MainFragmentViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)

        onNavigationItemSelected(binding.root.findViewById(R.id.bottom_nav), object : CustomNavCallbacks{
            override fun tabSelected(id: Int) {
                Log.e("MainFragment", "Tab is clicked, $id")
                Log.e("MainFragment", "Is this saved tab? ${id == SAVED}")
            }
        })

        return binding.root
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_main, container, false)
//        val navigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
//        navigationView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.nav_action_feed -> swapFragment(DenmeFragment())
//                R.id.nav_action_saved -> swapFragment(DenmeFragment())
//                R.id.nav_action_settings -> swapFragment(DenmeFragment())
//                else -> false
//            }
//        }
//        if (savedInstanceState == null) {
//            swapFragment(DenmeFragment())
//        }
//        return view
//    }
//
//    private fun swapFragment(fragment: Fragment): Boolean {
//        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_frame, fragment)?.commit()
//        return true
//    }
}