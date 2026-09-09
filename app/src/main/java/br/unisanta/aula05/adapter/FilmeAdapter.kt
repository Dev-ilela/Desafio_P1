package br.unisanta.aula05.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.aula05.R
import br.unisanta.aula05.model.Filme
import coil.load
import okhttp3.internal.notifyAll

class FilmeAdapter(private val filmes:MutableList<Filme>):
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>()
{
    class ViewHolder(itemView : View):
        RecyclerView.ViewHolder(itemView){
        val tituloFilme = itemView.findViewById<TextView>(R.id.tv_titulo)
        val genero = itemView.findViewById<TextView>(R.id.tv_genero)
        val imageFilme = itemView.findViewById<ImageView>(R.id.img_filme)

        val btnExcluir = itemView.findViewById<Button>(R.id.btn_excluir)
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
        holder.genero.text = filme.genero
        holder.imageFilme.load(filme.url)

        holder.btnExcluir.setOnClickListener {
            filmes.remove(filme)
            notifyDataSetChanged();
        }

    }
}