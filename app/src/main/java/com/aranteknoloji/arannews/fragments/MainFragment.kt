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
        return binding.root
    }
}