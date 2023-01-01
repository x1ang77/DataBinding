package com.xiangze.databinding.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData(0)

    fun incrementCounter() {
        counter.value = counter.value?.let {
            it + 1
        }
    }

    fun decrementCounter() {
        counter.value = counter.value?.let {
            it - 1
        }
    }
}