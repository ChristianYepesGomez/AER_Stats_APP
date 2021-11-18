package com.example.aceptaelretostats.data.network

import com.example.aceptaelretostats.core.RetrofitHelper
import com.example.aceptaelretostats.model.StatsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET

interface StatsApiClient {
    @GET("/.json")
    suspend fun getAllStats(): Response<StatsModel>
}

class StatsService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getStats(): StatsModel {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(StatsApiClient::class.java).getAllStats()
            response.body()!!
        }
    }

}