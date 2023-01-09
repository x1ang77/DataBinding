package com.xiangze.databinding.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val counter: MutableLiveData<Int> = MutableLiveData(0)
    val goToLogin: MutableSharedFlow<Unit> = MutableSharedFlow()
//    val goToLogin2: MutableLiveData<String> = MutableLiveData()
    val goToRegister: MutableSharedFlow<Unit> = MutableSharedFlow()

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

    fun onLoginClicked() {
        // use emit function for one time event
        // live data always fires, so using live data for one time events is a bad idea
        viewModelScope.launch {
            goToLogin.emit(Unit)
//            goToLogin2.value = "go"
        }
    }

    fun onRegisterClicked() {
        viewModelScope.launch {
            goToRegister.emit(Unit)
        }
    }
}