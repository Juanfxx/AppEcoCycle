package com.example.ecocycle

import java.io.Serializable

data class User(
    val nombre_usuario: String = "",
    val contraseña: String = "",
    val email: String = ""
) : Serializable