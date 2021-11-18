package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aceptaelretostats.domain.GetStatsUseCase
import com.example.aceptaelretostats.model.StatsModel
import kotlinx.coroutines.launch

class StatsViewModel : ViewModel() {

    val quoteModel = MutableLiveData<List<StatsModel>>()
    var getStatsUseCase = GetStatsUseCase()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getStatsUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}