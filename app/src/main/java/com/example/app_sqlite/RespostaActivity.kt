package com.example.app_sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app_sqlite.db.DBHepler

class RespostaActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)
        val edtNome: EditText = findViewById(R.id.edtNome)
        val edtObs: EditText = findViewById(R.id.edtObs)
        val edtTel: EditText = findViewById(R.id.edtTel)
        val btnConfirmar: Button = findViewById(R.id.btnCadastrar)

        edtNome.setText(intent.getString("nome"))
        edtObs.setText(intent.getString("observacao"))
        edtTel.setText(intent.getString("tel"))

        val db = DBHepler(this, null)

        btnConfirmar.setOnClickListener{
            db.addPessoa(edtNome.text.toString(), edtObs.text.toString(), edtTel.text.toString())
            finish()
        }
    }
}