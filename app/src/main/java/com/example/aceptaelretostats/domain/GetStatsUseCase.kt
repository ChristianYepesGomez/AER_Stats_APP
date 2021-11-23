package com.example.aceptaelretostats.domain

import com.example.aceptaelretostats.data.network.StatsRepository
import com.example.aceptaelretostats.model.StatsModel

//Domain to handle the response to the view Model

class GetStatsUseCase {

    private val repository = StatsRepository()

    suspend operator fun invoke(): StatsModel? = repository.getAllStats()

}