package com.example.mvvm.model

data class UserModel(
    val id: String,
    val nick: String,
    val accepteds: String,
    val intents: String,
    val resolved: String
)

class UserProvider {
    companion object {
        var quotes: List<UserModel> = emptyList()
    }
}