package br.unisanta.aula05.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.aula05.R
import br.unisanta.aula05.adapter.FilmeAdapter
import br.unisanta.aula05.dao.FilmeDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FilmeListaActivity : AppCompatActivity(R.layout.activity_filme_lista) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv_filmes = findViewById<RecyclerView>(R.id.rv_filmes)
        val fab_voltar_menu_filme = findViewById<FloatingActionButton>(R.id.fab_voltar_menu_filme)

        rv_filmes.adapter = FilmeAdapter(FilmeDAO.obter())
        rv_filmes.layoutManager  = GridLayoutManager(this, 2)

        fab_voltar_menu_filme.setOnClickListener{
            finish()
        }
    }
}