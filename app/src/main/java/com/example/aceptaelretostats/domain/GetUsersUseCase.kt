package com.example.mvvm.domain

import com.example.mvvm.data.network.UserRepository
import com.example.mvvm.model.UserModel

class GetUsersUseCase {

    private val repository = UserRepository()

    suspend operator fun invoke(): List<UserModel>? = repository.getAllUsers()

}