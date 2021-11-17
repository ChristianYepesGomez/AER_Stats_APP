package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.domain.GetUsersUseCase
import com.example.mvvm.model.UserModel
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val quoteModel = MutableLiveData<List<UserModel>>()
    var getUsersUseCase = GetUsersUseCase()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsersUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}