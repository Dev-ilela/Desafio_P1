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
import br.unisanta.aula05.dao.TarefaDAO
import br.unisanta.aula05.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TarefaActivity : AppCompatActivity(R.layout.activity_tarefa) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        TarefaDAO.salvar(Tarefa("Pintar a piscina de rosa", true))
        TarefaDAO.salvar(Tarefa("Aspirar a entrada da garagem", false))

        val edt_nome_tarefa = findViewById<EditText>(R.id.edt_nome_tarefa)
        val btn_salvar_tarefa = findViewById<Button>(R.id.btn_salvar_tarefa)
        val fab_tarefa_lista = findViewById<FloatingActionButton>(R.id.fab_tarefa_lista)
        val fab_volta_menu_principal_tarefa = findViewById<FloatingActionButton>(R.id.fab_volta_menu_principal_tarefa)

        btn_salvar_tarefa.setOnClickListener{
            val nomeTarefa = edt_nome_tarefa.text.toString()

            val tarefa = Tarefa(nomeTarefa, false)
            val mensagem = TarefaDAO.salvar(tarefa)

            edt_nome_tarefa.text.clear()

            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }

        fab_tarefa_lista.setOnClickListener{
            val intent = Intent(this, TarefaListaActivity::class.java)
            startActivity(intent)
        }

        fab_volta_menu_principal_tarefa.setOnClickListener {
            finish()
        }
    }
}