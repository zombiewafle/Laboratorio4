package com.example.laboratorio4

import android.app.Activity
import com.example.laboratorio4.User

class util {
    companion object{
        var lista: MutableList<User> = mutableListOf(User("Oscar Saravia", "21882345", "oscar44@mail.es"))
        var listaroles: MutableList<String> = mutableListOf()
        var invitados: Int = 0
        var registrados: Int = 0
        var listado: String = ""
        val spinnerOption = arrayOf("Anfitrion")
    }
}