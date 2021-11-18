package com.example.aceptaelretostats.data.network

import com.example.aceptaelretostats.model.StatsModel
import com.example.aceptaelretostats.model.StatsProvider

class StatsRepository {

    private val api = StatsService()

    suspend fun getAllStats(): StatsModel {
        val response = api.getStats()
        StatsProvider.stats = response
        return response
    }
}