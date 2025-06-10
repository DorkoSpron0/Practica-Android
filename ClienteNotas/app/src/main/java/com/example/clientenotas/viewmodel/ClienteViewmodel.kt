package com.example.clientenotas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.clientenotas.data.local.Cliente
import com.example.clientenotas.repository.ClienteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClienteViewmodel(private val clienteRepository: ClienteRepository): ViewModel() {

    val clientes = clienteRepository.allClientes.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500),
        initialValue = emptyList()
    )

    fun VMagregarCliente(title: String, correo: String) {
        val newCliente = Cliente(title = title, correo = correo);
        viewModelScope.launch {
            clienteRepository.insert(newCliente)
        }
    }

    fun VMdeleteCliente(cliente: Cliente){
        viewModelScope.launch {
            clienteRepository.delete(cliente)
        }
    }

    fun VMupdateCliente(cliente: Cliente){
        val clienteUpdated = Cliente(id = cliente.id, title = cliente.title, correo = cliente.correo)
        viewModelScope.launch {
            clienteRepository.updateCliente(clienteUpdated)
        }
    }

    fun VMdeleteById(id: Int){
        viewModelScope.launch {
            clienteRepository.deleteById(id)
        }
    }

    fun VMgetClienteConNotas(clienteId: Int){
        viewModelScope.launch {
            clienteRepository.getClienteConNotas(clienteId)
        }
    }
}

class ClienteViewModelFactory(private val repository: ClienteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClienteViewmodel(repository) as T
    }
}