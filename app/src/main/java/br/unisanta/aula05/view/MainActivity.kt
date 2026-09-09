package br.unisanta.aula05.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.aula05.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_cadastrar_filmes = findViewById<Button>(R.id.btn_cadastrar_filmes)

        btn_cadastrar_filmes.setOnClickListener{

            val expectedLogin = "user@unisanta.com.br"
            val expectedPassword = "user123"

            val textLogin = findViewById<TextView>(R.id.edt_login)

            val textSenha = findViewById<TextView>(R.id.edt_senha)

            if(textLogin.text.toString() != expectedLogin || textSenha.text.toString() != expectedPassword)
            {
                Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, FilmeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}