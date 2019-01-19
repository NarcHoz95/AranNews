package com.aranteknoloji.arannews.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.aranteknoloji.arannews.R
import com.aranteknoloji.arannews.architect.BaseViewModel

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

enum class MenuItemIDs(val id: Int) {
    SETTINGS(R.id.action_settings),
    DEFAULT(0)
}