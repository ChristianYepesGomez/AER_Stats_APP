package com.example.mvvm.data.network

import com.example.mvvm.model.UserModel
import com.example.aceptaelretostats.model.UserProvider

class UserRepository {

    private val api = UserService()

    suspend fun getAllStats(): List<UserModel> {
        val response = api.getUsers()
        UserProvider.listUsers = response
        println(response)
        return response
    }
}