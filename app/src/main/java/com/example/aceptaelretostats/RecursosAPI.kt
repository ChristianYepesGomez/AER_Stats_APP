package com.example.aceptaelretostats

import com.example.aceptaelretostats.services.UsersService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecursosAPI {

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl("http://192.168.1.31:3000/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getUsers(query: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersService::class.java).getUsers("$query/")
            println(call)
            val userList = call.body()
            if (call.isSuccessful) {
                println("------------------------------")
                println("USUARIO" + userList?.get(0));
                println("------------------------------")

            } else {
                println(userList)
                println("No se pudo establecer conexión")
            }

        }
    }

    fun getProblems(query: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersService::class.java).getUsers("$query/")
            val user = call.body()
            if (call.isSuccessful) {
                println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                println("USUARIO" + user?.get(0));
            } else {
                //show error
            }
        }
    }
}