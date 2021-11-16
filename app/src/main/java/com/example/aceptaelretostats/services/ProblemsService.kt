package com.example.aceptaelretostats.services

import com.example.aceptaelretostats.customClass.Problem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ProblemsService {
    @GET
    suspend fun getUsers(@Url url: String): Response<List<Problem>>
}