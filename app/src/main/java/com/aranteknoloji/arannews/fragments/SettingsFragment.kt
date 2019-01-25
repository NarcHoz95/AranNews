package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseMenuFragment
import com.aranteknoloji.arannews.databinding.FragmentSettingsBinding
import com.aranteknoloji.arannews.viewmodels.SettingsFragmentViewModel

class SettingsFragment: BaseMenuFragment<SettingsFragmentViewModel>(SettingsFragmentViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSettingsBinding.inflate(inflater)
        binding.settingsVM = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}