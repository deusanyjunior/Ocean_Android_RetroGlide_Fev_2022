package com.oceanbrasil.ocean_android_retroglide_fev_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texto = findViewById<TextView>(R.id.texto)
        val textoEditavel = findViewById<EditText>(R.id.textoEditavel)
        val botaoAtualizarTexto = findViewById<Button>(R.id.botaoAtualizarTexto)

        botaoAtualizarTexto.setOnClickListener {
            val novoTexto = textoEditavel.text.toString()

            if (novoTexto.isNotBlank()) {
                texto.text = novoTexto
            } else {
                textoEditavel.error = "Digite um texto, por gentileza!"
            }
        }

    }
}