package com.example.aceptaelretostats.services

import com.example.aceptaelretostats.customClass.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UsersService {
    @GET
    suspend fun getUsers(@Url url: String): Response<List<User>>
}