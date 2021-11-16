package com.example.aceptaelretostats

import android.widget.Toast
import com.example.aceptaelretostats.customClass.User
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

    fun getUsers(query: String): List<User>? {
        var userList: List<User>? = null

        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(UsersService::class.java).getUsers("$query/")
            userList = call.body()!!
            println(call)
            if (call.isSuccessful) {


            } else {

                println("Fallo de conexión con la api")

            }

        }
        return userList
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