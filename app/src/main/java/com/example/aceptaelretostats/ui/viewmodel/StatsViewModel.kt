package com.example.aceptaelretostats.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aceptaelretostats.domain.GetStatsUseCase
import com.example.aceptaelretostats.model.Institutions
import com.example.aceptaelretostats.model.Problems
import com.example.aceptaelretostats.model.StatsModel
import com.example.aceptaelretostats.model.Users
import kotlinx.coroutines.launch

class StatsViewModel : ViewModel() {

    //Stats view model to handle live data

    var statsModel = MutableLiveData<StatsModel>()
    var getStatsUseCase = GetStatsUseCase()
    val isLoading = MutableLiveData<Boolean>()
    var filteredUsers = mutableListOf<Users>()
    var filteredInstitutions = mutableListOf<Institutions>()
    var filteredProblems = mutableListOf<Problems>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            var result = getStatsUseCase()
            statsModel.postValue(result!!)
            isLoading.postValue(false)

        }
    }

    fun getUsersFilteredBy(query: String) {
        viewModelScope.launch {
            filteredUsers.clear()
            statsModel.value?.users = filteredUsers

            var result = getStatsUseCase()
            if (result != null) {
                for (user in result.users) {
                    if (user.nick.lowercase().contains(query.lowercase())) {
                        filteredUsers.add(user)
                    }
                }
            }

            if (result != null) {
                println(filteredUsers)
                result.users = filteredUsers

            }

            statsModel.postValue(result!!)


        }
    }

    fun getInstitutionsFilteredBy(query: String) {
        viewModelScope.launch {
            filteredInstitutions.clear()

            var result = getStatsUseCase()
            if (result != null) {
                for (institution in result.institution) {
                    if (institution.institution.lowercase().contains(query.lowercase())) {
                        filteredInstitutions.add(institution)
                    }
                }
            }

            if (result != null) {

                result.institution = filteredInstitutions

            }

            statsModel.postValue(result!!)

        }
    }

    fun getProblemsFilteredBy(query: String) {
        viewModelScope.launch {
            filteredProblems.clear()

            var result = getStatsUseCase()
            if (result != null) {

                for (problem in result.problems) {
                    if (problem.name.lowercase().contains(query.lowercase())) {
                        filteredProblems.add(problem)
                    }
                }
            }

            if (result != null) {
                println(filteredProblems)
                result.problems = filteredProblems
            }

            statsModel.postValue(result!!)
            

        }
    }

}