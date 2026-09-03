package br.unisanta.aula05.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.aula05.R
import br.unisanta.aula05.model.Tarefa

class TarefaAdapter(private var tarefas:List<Tarefa>):
    RecyclerView.Adapter<TarefaAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View):
        RecyclerView.ViewHolder(itemView){
        val nomeTarefa = itemView.findViewById<TextView>(R.id.tv_tarefa)
        val concluido = itemView.findViewById<CheckBox>(R.id.chb_concluido)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.nomeTarefa.text = tarefa.nome
        holder.concluido.isChecked = tarefa.concluido

        holder.concluido.setOnCheckedChangeListener { _, isChecked ->  tarefa.concluido = isChecked}
    }

}