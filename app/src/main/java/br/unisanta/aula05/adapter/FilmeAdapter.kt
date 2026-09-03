package br.unisanta.aula05.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.aula05.R
import br.unisanta.aula05.model.Filme

class FilmeAdapter(private val filmes:List<Filme>):
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View):
        RecyclerView.ViewHolder(itemView){
        val tituloFilme = itemView.findViewById<TextView>(R.id.tv_titulo_filme)
        val diretor = itemView.findViewById<TextView>(R.id.tv_diretor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.tituloFilme.text = filme.titulo
        holder.diretor.text = filme.diretor
    }
}