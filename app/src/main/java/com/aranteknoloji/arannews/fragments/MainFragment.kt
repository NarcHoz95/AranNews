package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseFragment
import com.aranteknoloji.arannews.databinding.FragmentMainBinding
import com.aranteknoloji.arannews.viewmodels.MainFragmentViewModel

class MainFragment: BaseFragment<MainFragmentViewModel>(MainFragmentViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
//        onNavigationItemSelected(binding.root.findViewById(Menus.BOTTOM_NAV), viewModel.navCallbacks)
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