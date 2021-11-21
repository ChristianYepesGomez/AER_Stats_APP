package com.example.aceptaelretostats.model

import androidx.lifecycle.MutableLiveData

data class StatsModel(
    var users: MutableList<Users>,
    val problems: MutableList<Problems>,
    val institution: MutableList<Institutions>
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