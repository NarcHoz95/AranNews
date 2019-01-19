package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseFragment
import com.aranteknoloji.arannews.databinding.FragmentDenmeBinding
import com.aranteknoloji.arannews.viewmodels.DenemVM

class DenmeFragment: BaseFragment<DenemVM>(DenemVM::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDenmeBinding.inflate(inflater)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}