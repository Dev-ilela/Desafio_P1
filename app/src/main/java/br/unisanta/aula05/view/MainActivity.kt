package br.unisanta.aula05.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        val btn_menu_filmes = findViewById<Button>(R.id.btn_menu_filmes)
        val btn_menu_tarefa = findViewById<Button>(R.id.btn_menu_tarefas)

        btn_menu_filmes.setOnClickListener{
            val intent = Intent(this, FilmeActivity::class.java)
            startActivity(intent)
        }

        btn_menu_tarefa.setOnClickListener{
            val intent = Intent(this, TarefaActivity::class.java)
            startActivity(intent)
        }
    }
}