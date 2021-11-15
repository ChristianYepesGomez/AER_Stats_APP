package com.example.aceptaelretostats

import java.util.ArrayList

import com.google.gson.annotations.SerializedName

class Users {
    @SerializedName("results")

    val results: ArrayList<User>? = null

    override fun toString(): String {
        return results.toString()
    }
}