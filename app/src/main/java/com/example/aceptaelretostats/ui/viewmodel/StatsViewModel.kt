package com.example.aceptaelretostats.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aceptaelretostats.domain.GetStatsUseCase
import com.example.aceptaelretostats.model.StatsModel
import com.example.aceptaelretostats.model.Users
import kotlinx.coroutines.launch

class StatsViewModel : ViewModel() {

    var statsModel = MutableLiveData<StatsModel>()
    var getStatsUseCase = GetStatsUseCase()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getStatsUseCase()

            statsModel.postValue(result!!)
            isLoading.postValue(false)

        }
    }

    fun getUsersFiltered() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getStatsUseCase()

            statsModel.postValue(result!!)
            isLoading.postValue(false)

        }
    }

}