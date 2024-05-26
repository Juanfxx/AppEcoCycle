package com.example.ecocycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewForgotPassword: TextView
    private lateinit var textViewSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Vincular vistas
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword)
        textViewSignUp = findViewById(R.id.textViewSignUp)

        // Agregar un listener al botón de inicio de sesión
        buttonLogin.setOnClickListener {
            // Aquí puedes manejar la lógica de inicio de sesión
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            // Por ejemplo, puedes llamar a una función para iniciar sesión con estos datos
            login(email, password)
        }

        // Agregar un listener al texto "¿Olvidaste tu contraseña?"
        textViewForgotPassword.setOnClickListener {
            // Aquí puedes manejar la acción de olvidar la contraseña
        }

        // Agregar un listener al texto "¿No tienes una cuenta? Regístrate"
        textViewSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(email: String, password: String) {
        // Aquí puedes implementar la lógica de inicio de sesión, como enviar los datos al servidor
        // y manejar la respuesta, por ejemplo, mostrando un mensaje de éxito o error.

        // Supongamos que el inicio de sesión es exitoso:
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}
