package com.example.aceptaelretostats.core

import com.example.aceptaelretostats.data.network.StatsApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.31:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
    }
}