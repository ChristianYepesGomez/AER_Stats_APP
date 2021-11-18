package com.example.aceptaelretostats.domain

import com.example.aceptaelretostats.data.network.UserRepository
import com.example.aceptaelretostats.model.StatsModel

class GetUsersUseCase {

    private val repository = UserRepository()

    suspend operator fun invoke(): List<UserModel>? = repository.getAllUsers()

}