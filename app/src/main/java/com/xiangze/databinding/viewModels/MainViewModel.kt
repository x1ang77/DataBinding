package com.xiangze.databinding.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData(0)
    val gotoLogin: MutableSharedFlow<Unit> = MutableSharedFlow()

    fun incrementCounter() {
        counter.value = counter.value?.let { it + 1 }
    }

    fun decrementCounter() {
        counter.value = counter.value?.let { it - 1 }
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            gotoLogin.emit(Unit)
        }
    }
}