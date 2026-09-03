package br.unisanta.aula05.dao

import br.unisanta.aula05.model.Filme

class FilmeDAO {
    companion object{
        private val filmes = mutableListOf<Filme>()

        fun salvar(filme:Filme):String{
            filmes.add(filme)
            return "Filme salvo com sucesso!"
        }

        fun obter():List<Filme>{
            return filmes
        }
    }
}