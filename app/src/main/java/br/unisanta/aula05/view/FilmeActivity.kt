package br.unisanta.aula05.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.aula05.R
import br.unisanta.aula05.dao.FilmeDAO
import br.unisanta.aula05.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilmeActivity : AppCompatActivity(R.layout.activity_filme) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edt_titulo = findViewById<EditText>(R.id.edt_titulo)
        val edt_diretor = findViewById<EditText>(R.id.edt_diretor)
        val btn_salvar_filme = findViewById<Button>(R.id.btn_salvar_filme)
        val fab_filme_lista = findViewById<FloatingActionButton>(R.id.fab_filme_lista)
        val fab_voltar_menu_principal = findViewById<FloatingActionButton>(R.id.fab_voltar_menu_principal)

        btn_salvar_filme.setOnClickListener {
            val titulo = edt_titulo.text.toString()
            val diretor = edt_diretor.text.toString()

            val filme = Filme(titulo, diretor)
            val mensagem = FilmeDAO.salvar(filme)

            edt_titulo.text.clear()
            edt_diretor.text.clear()

            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }

        fab_filme_lista.setOnClickListener{
            val intent = Intent(this, FilmeListaActivity::class.java)
            startActivity(intent)
        }

        fab_voltar_menu_principal.setOnClickListener {
            finish()
        }
    }
}