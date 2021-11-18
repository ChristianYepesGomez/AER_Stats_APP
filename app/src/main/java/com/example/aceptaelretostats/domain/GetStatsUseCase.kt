package com.example.aceptaelretostats.domain

import com.example.aceptaelretostats.data.network.StatsRepository
import com.example.aceptaelretostats.model.StatsModel

class GetStatsUseCase {

    private val repository = StatsRepository()

    suspend operator fun invoke(): StatsModel? = repository.getAllStats()

}