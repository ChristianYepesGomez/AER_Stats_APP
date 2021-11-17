package com.example.mvvm.data.network

import com.example.mvvm.core.RetrofitHelper
import com.example.mvvm.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/getUsers")
    suspend fun getAllUsers(): Response<List<UserModel>>
}

class UserService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsers(): List<UserModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllUsers()
            println(response)
            response.body() ?: emptyList()
        }
    }

}