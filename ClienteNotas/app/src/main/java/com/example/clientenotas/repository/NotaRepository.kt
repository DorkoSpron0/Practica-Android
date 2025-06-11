package com.example.clientenotas.repository

import com.example.clientenotas.data.local.ClienteConNotas
import com.example.clientenotas.data.local.Nota
import com.example.clientenotas.data.local.NotaDao
import kotlinx.coroutines.flow.Flow

class NotaRepository(private val dao: NotaDao) {

    val allNotas: Flow<List<Nota>> = dao.getAll()

    suspend fun insert(nota: Nota){
        dao.insert(nota)
    }

    suspend fun updateNota(nota: Nota){
        dao.updateNota(nota)
    }

    suspend fun delete(nota: Nota){
        dao.delete(nota)
    }

    fun getById(id: Int){
        dao.getById(id)
    }

    suspend fun getNotasDeCliente(clienteId: Int): ClienteConNotas? {
        return dao.getNotasDeCliente(clienteId)
    }
}