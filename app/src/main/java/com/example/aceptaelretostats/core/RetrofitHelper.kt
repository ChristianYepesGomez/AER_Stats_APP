package com.example.aceptaelretostats.core

import com.example.aceptaelretostats.data.network.StatsApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    //Use of retrofit to call the API
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://ec2-15-236-92-83.eu-west-3.compute.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}