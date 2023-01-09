package com.xiangze.databinding.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    val username: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    fun onLoginBtnClicked() {
        Log.d("debugging", "${username.value} ${password.value}")
    }
}