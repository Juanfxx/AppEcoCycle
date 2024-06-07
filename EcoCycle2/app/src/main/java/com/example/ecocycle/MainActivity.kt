package com.example.ecocycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal_layout)

        // Botón para comenzar a reciclar
        val buttonStartRecycling = findViewById<Button>(R.id.buttonStartRecycling)
        buttonStartRecycling.setOnClickListener {
            val intent = Intent(this, PublicarActividad::class.java)
            startActivity(intent)
        }

        // Botón para los puntos de reciclaje
        val buttonRecyclingPoints = findViewById<Button>(R.id.buttonRecyclingPoints)
        buttonRecyclingPoints.setOnClickListener {
            val intent = Intent(this, PuntosReciclaje::class.java)
            startActivity(intent)
        }

        // Botón para los recursos educativos
        val buttonEducationalResources = findViewById<Button>(R.id.buttonEducationalResources)
        buttonEducationalResources.setOnClickListener {
            val intent = Intent(this, RecursosEducativos::class.java)
            startActivity(intent)
        }

        // Botón para publicar
        val buttonPublish = findViewById<Button>(R.id.buttonPublish)
        buttonPublish.setOnClickListener {
            val intent = Intent(this, PublicarActividad::class.java)
            startActivity(intent)
        }

        // Redirigir a LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Cierra MainActivity para que el usuario no pueda volver con el botón de retroceso
    }
}
