package com.aranteknoloji.arannews.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.aranteknoloji.arannews.architect.BaseViewModel

class DenemVM: BaseViewModel() {

    val data = MutableLiveData<Int>()
    private var number: Int = 0

    fun inc() {
        data.postValue(++number)
        listener?.toolbarTitleChanged(number.toString())
    }
}