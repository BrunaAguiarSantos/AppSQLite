package com.example.app_sqlite

import android.content.Intent
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtTel: EditText = findViewById(R.id.edtTel)
        val edtObs: EditText = findViewById(R.id.edtObs)

        val btnCadastrar: Button = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
        val intent = Intent(this, RespostaActivity::class.java)
        intent.putExtra("nome", edtNome.text.toString())
        intent.putExtra("cep", edtObs.text.toString())
        intent.putExtra("telefone", edtTel.text.toString())

        startActivity(intent)

    }
}
}