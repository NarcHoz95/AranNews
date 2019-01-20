package com.aranteknoloji.arannews.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.aranteknoloji.arannews.architect.BaseViewModel
import com.aranteknoloji.arannews.architect.MenuItemIDs

class DenemVM: BaseViewModel() {

    val data = MutableLiveData<Int>()
    private var number: Int = 0

    init {
        optionItemSelectedListener {
            when (it) {
                MenuItemIDs.SETTINGS.id -> data.postValue(++number)
            }
        }
    }

    fun inc() {
        data.postValue(++number)
        listener?.toolbarTitleChanged(number.toString())
    }
}