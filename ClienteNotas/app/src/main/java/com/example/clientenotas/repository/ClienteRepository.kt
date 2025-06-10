package com.example.clientenotas.repository

import com.example.clientenotas.data.local.Cliente
import com.example.clientenotas.data.local.ClienteDao
import kotlinx.coroutines.flow.Flow

class ClienteRepository(private val dao: ClienteDao) {
    val allClientes: Flow<List<Cliente>> = dao.getAll();

    suspend fun insert(cliente: Cliente){
        dao.insert(cliente)
    }

    suspend fun delete(cliente: Cliente){
        dao.delete(cliente)
    }

    suspend fun updateCliente(cliente: Cliente){
        dao.updateCliente(cliente)
    }

    suspend fun deleteById(id: Int){
        dao.deleteById(id)
    }

    suspend fun getClienteConNotas(clienteId: Int){
        dao.getClienteConNotas(clienteId)
    }
}