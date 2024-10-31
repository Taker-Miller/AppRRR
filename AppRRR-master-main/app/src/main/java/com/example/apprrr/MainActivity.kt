package com.example.apprrr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun login(@Suppress("UNUSED_PARAMETER") view: View) {
        val campo1 = findViewById<EditText>(R.id.correo)
        val correo = campo1.text.toString()
        val campo2 = findViewById<EditText>(R.id.contraseña)
        val contrasena = campo2.text.toString()

        if (correo == "c1" && contrasena == "123") {
            val intent = Intent(this, Principal1::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Error en las credenciales", Toast.LENGTH_SHORT).show()
        }
    }

    fun crearCuenta(@Suppress("UNUSED_PARAMETER") view: View) {
        val intent = Intent(this, ReguistrarCuenta::class.java)
        startActivity(intent)
    }




}
