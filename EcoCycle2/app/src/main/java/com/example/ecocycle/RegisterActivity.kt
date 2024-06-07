package com.example.ecocycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonBackToMenu: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var reference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.title="Registros"
        InicializarVariables()

        buttonRegister.setOnClickListener{
            ValidarDatos()
        }
    }
    private fun InicializarVariables(){
        editTextEmail =  findViewById(R.id.editTextEmail)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword =  findViewById(R.id.editTextPassword)
        auth = FirebaseAuth.getInstance()

    }
    private fun ValidarDatos(){
        val nombre_usuario: String =editTextUsername.text.toString()
        val contraseña: String = editTextPassword.text.toString()
        val email: String = editTextEmail.text.toString()


        if (nombre_usuario.isEmpty()){
            Toast.makeText(applicationContext,"Ingrese nombre de usuario",Toast.LENGTH_SHORT).show()
        }
        else if (contraseña.isEmpty()){
            Toast.makeText(applicationContext,"Ingrese la contraseña",Toast.LENGTH_SHORT).show()
        }
        else if (email.isEmpty()){
            Toast.makeText(applicationContext,"Ingrese su correo",Toast.LENGTH_SHORT).show()
        }
        else{
            RegistrarUsuario(email, contraseña)
        }
    }
    private fun RegistrarUsuario(email:String,contraseña: String){
        auth.createUserWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener{task->
                if (task.isSuccessful){
                    var uid: String =""
                    uid = auth.currentUser!!.uid
                    reference = FirebaseDatabase.getInstance().reference.child("Usuarios").child(uid)

                    val hashMap = HashMap <String, Any>()
                    val h_nombre_usuario : String = editTextUsername.text.toString()
                    val h_email : String = editTextEmail.toString()

                    hashMap["uid"] = uid
                    hashMap["nombre_usuario"]= h_nombre_usuario
                    hashMap["email"]= h_email
                    hashMap["imagen"] = ""
                    hashMap["buscar"]=h_nombre_usuario.lowercase()

                    reference.updateChildren(hashMap).addOnCompleteListener{task2->
                        if (task2.isSuccessful){
                            val Intent = Intent(this@RegisterActivity, PrincipalActivity::class.java)
                            Toast.makeText(applicationContext,"se ha registrado con exito", Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                        }
                    }.addOnFailureListener{e->
                        Toast.makeText(applicationContext,"{${e.message}}", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(applicationContext,"ha ocurrido un error", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener{e->
                Toast.makeText(applicationContext,"{${e.message}}", Toast.LENGTH_SHORT).show()
            }
    }
}
