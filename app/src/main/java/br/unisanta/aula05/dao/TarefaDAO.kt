package br.unisanta.aula05.dao

import br.unisanta.aula05.model.Tarefa

class TarefaDAO {
    companion object{
        private val tarefas = mutableListOf<Tarefa>()

        fun salvar(tarefa: Tarefa):String{
            tarefas.add(tarefa)
            return "Tarefa salva com sucesso!"
        }

        fun obter():List<Tarefa>{
            return tarefas
        }
    }
}