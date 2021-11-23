package com.example.aceptaelretostats.model


//Custom data classes for the API data
data class StatsModel(
    var users: MutableList<Users>,
    var problems: MutableList<Problems>,
    var institution: MutableList<Institutions>
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

data class Institutions(
    val institution: String,
)

class StatsProvider {
    companion object {
        lateinit var stats: StatsModel
    }
}