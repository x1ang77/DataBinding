package com.xiangze.databinding.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun onRegisterBtnClicked() {
        Log.d("debugging", "${username.value} ${password.value}")
    }
}