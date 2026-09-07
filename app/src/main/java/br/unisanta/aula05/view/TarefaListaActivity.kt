package br.unisanta.aula05.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.aula05.R
import br.unisanta.aula05.adapter.TarefaAdapter
import br.unisanta.aula05.dao.TarefaDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TarefaListaActivity : AppCompatActivity(R.layout.activity_tarefa_lista) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rv_tarefas = findViewById<RecyclerView>(R.id.rv_tarefas)
        val fab_voltar_menu_tarefa = findViewById<FloatingActionButton>(R.id.fab_voltar_menu_tarefa)

        rv_tarefas.adapter = TarefaAdapter(TarefaDAO.obter())
        rv_tarefas.layoutManager  = LinearLayoutManager(this)

        fab_voltar_menu_tarefa.setOnClickListener{
            finish()
        }
    }
}