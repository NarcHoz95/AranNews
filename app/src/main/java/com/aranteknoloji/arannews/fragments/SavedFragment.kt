package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseMenuFragment
import com.aranteknoloji.arannews.architect.Menus
import com.aranteknoloji.arannews.databinding.FragmentSavedBinding
import com.aranteknoloji.arannews.viewmodels.SavedFragmentViewModel

class SavedFragment: BaseMenuFragment<SavedFragmentViewModel>(SavedFragmentViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSavedBinding.inflate(inflater)
        binding.savedVM = viewModel
        binding.setLifecycleOwner(this)
        menuRes = Menus.MAIN
        return binding.root
    }
}