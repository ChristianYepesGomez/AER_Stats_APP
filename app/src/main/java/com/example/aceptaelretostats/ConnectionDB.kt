package com.example.aceptaelretostats

import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

object ConnectionDB {

    @JvmStatic
    fun connection(): Connection? {
        lateinit var con: Connection
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql//192.168.1.6?employees?serverTimezone=UTC",
                "edu-dbms-orm",
                "dbrootpass"
            )
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return con
    }

}