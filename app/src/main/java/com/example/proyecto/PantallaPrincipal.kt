package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyecto.Marcaje.MainActivity

class PantallaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btnMarcaje=findViewById<Button>(R.id.btnMarcaje)
        btnMarcaje.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnInfo=findViewById<Button>(R.id.btnDatosTrabajador)
        btnInfo.setOnClickListener {
            val intent=Intent(this,DatosTrabajador::class.java)
            startActivity(intent)
        }
        val btnChat=findViewById<Button>(R.id.btnChat)
        btnChat.setOnClickListener {
            val intent=Intent(this,Chat::class.java)
            startActivity(intent)
        }
        val btnCerrarSesion=findViewById<Button>(R.id.buttonCerrarSesion)
        btnCerrarSesion.setOnClickListener {
            val intent=Intent(this,CerrarSesion::class.java)
            startActivity(intent)
        }



    }
}