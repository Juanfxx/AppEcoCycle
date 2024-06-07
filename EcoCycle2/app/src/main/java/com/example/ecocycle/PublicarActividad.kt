package com.example.ecocycle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PublicarActividad : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comenzar_reciclaje)

        val publishButton = findViewById<Button>(R.id.buttonPublish)

        publishButton.setOnClickListener {
            // Obtener referencias a los campos de texto
            val nombreEditText = findViewById<EditText>(R.id.editTextNombre)
            val tipoEditText = findViewById<EditText>(R.id.editTextTipo)
            val cantidadEditText = findViewById<EditText>(R.id.editTextCantidad)
            val fechaEditText = findViewById<EditText>(R.id.editTextFecha)
            val resumenEditText = findViewById<EditText>(R.id.editTextResumen)
            val ubicacionEditText = findViewById<EditText>(R.id.editTextUbicacion)

            // Obtener los valores ingresados en los campos de texto
            val nombre = nombreEditText.text.toString()
            val tipo = tipoEditText.text.toString()
            val cantidad = cantidadEditText.text.toString()
            val fecha = fechaEditText.text.toString()
            val resumen = resumenEditText.text.toString()
            val ubicacion = ubicacionEditText.text.toString()

            // Aquí puedes realizar acciones con los valores obtenidos, como enviarlos a un servidor o almacenarlos localmente
            // Por ahora, simplemente mostraremos un mensaje de publicación exitosa
            val mensaje = "Publicación exitosa:\nNombre: $nombre\nTipo: $tipo\nCantidad: $cantidad\nFecha: $fecha\nResumen: $resumen\nUbicación: $ubicacion"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}
