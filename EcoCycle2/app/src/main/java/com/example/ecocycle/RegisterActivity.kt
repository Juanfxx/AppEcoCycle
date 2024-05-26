package com.example.ecocycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Configurar el botón de registrar
        val buttonRegister: Button = findViewById(R.id.buttonRegister)
        buttonRegister.setOnClickListener {
            // Aquí puedes manejar la lógica de registro
            // Por ejemplo, puedes guardar los datos ingresados y/o navegar a otra pantalla

            // Lanzar la actividad del perfil
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Configurar el botón de volver al menú
        val buttonBackToMenu: Button = findViewById(R.id.buttonBackToMenu)
        buttonBackToMenu.setOnClickListener {
            // Cierra la actividad actual (RegisterActivity) y vuelve a la pantalla de inicio de sesión
            finish()
        }
    }
}

