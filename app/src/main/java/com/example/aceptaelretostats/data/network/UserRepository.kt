package com.example.mvvm.data.network

import com.example.mvvm.model.UserModel
import com.example.mvvm.model.UserProvider

class UserRepository {

    private val api = UserService()

    suspend fun getAllUsers(): List<UserModel> {
        val response = api.getQuotes()
        UserProvider.quotes = response
        return response
    }
}