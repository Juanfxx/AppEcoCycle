package com.example.ecocycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val buttonIngresar: Button = findViewById(R.id.buttonIngresar)

        buttonIngresar.setOnClickListener {
            // Aquí puedes agregar validaciones de los campos si es necesario

            // Cambiar a la vista principal de la app
            val intent = Intent(this, PrincipalActivity::class.java)
            startActivity(intent)
        }
    }
}

