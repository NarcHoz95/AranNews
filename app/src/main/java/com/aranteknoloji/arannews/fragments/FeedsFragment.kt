package com.aranteknoloji.arannews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aranteknoloji.arannews.architect.BaseMenuFragment
import com.aranteknoloji.arannews.databinding.FragmentFeedsBinding
import com.aranteknoloji.arannews.viewmodels.FeedsFragmentViewModel

class FeedsFragment: BaseMenuFragment<FeedsFragmentViewModel>(FeedsFragmentViewModel::class.java) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentFeedsBinding.inflate(inflater)
        binding.feedsVM = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }
}