package com.oceanbrasil.ocean_android_retroglide_fev_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Segunda Aula
        val textoDigitado = findViewById<TextView>(R.id.textoDigitado)
        val botaoVoltar = findViewById<Button>(R.id.botaoVoltar)

        val textoDaPrimeiraTela =
            intent
                .getStringExtra("TEXTO_DIGITADO")

        textoDigitado.text = textoDaPrimeiraTela

        botaoVoltar.setOnClickListener {
            finish()
        }

    }
}