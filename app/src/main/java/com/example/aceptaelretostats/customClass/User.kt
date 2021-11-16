package com.example.aceptaelretostats.customClass

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") var id: String,
    @SerializedName("nick") var nick: String,
    @SerializedName("accepteds") var accepteds: String,
    @SerializedName("intents") var intents: String,
    @SerializedName("resolved") var resolved: String,
)
