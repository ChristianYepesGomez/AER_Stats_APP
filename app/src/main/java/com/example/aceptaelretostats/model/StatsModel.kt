package com.example.aceptaelretostats.model

data class StatsModel(
    val users: List<Users>,
    val problems: List<Problems>
)

data class Users(
    val id: String,
    val nick: String,
    val accepteds: String,
    val intents: String,
    val resolved: String
)

data class Problems(
    val id: String,
    val name: String,
    val accepteds: String,
    val shipments: String,
)

class StatsProvider {
    companion object {
        lateinit var stats: StatsModel
    }
}