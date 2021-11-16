package com.example.aceptaelretostats.customClass

import com.google.gson.annotations.SerializedName

data class Problem(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("accepteds") var accepteds: String,
    @SerializedName("shipments") var shipments: String,
)
