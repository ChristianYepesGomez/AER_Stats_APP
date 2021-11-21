package com.example.mvvm.ui.viewmodel

import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aceptaelretostats.domain.GetStatsUseCase
import com.example.aceptaelretostats.model.StatsModel
import com.example.aceptaelretostats.model.Users
import kotlinx.coroutines.launch
import java.util.*

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

    fun getUsers(): MutableList<Users>? {
        return statsModel.value?.users
    }


}