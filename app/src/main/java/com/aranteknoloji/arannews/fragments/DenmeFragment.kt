package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseMenuFragment
import com.aranteknoloji.arannews.architect.Menus
import com.aranteknoloji.arannews.databinding.FragmentDenmeBinding
import com.aranteknoloji.arannews.viewmodels.DenemVM

class DenmeFragment: BaseMenuFragment<DenemVM>(DenemVM::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDenmeBinding.inflate(inflater)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
        menuRes = Menus.MAIN.id
        return binding.root
    }
}