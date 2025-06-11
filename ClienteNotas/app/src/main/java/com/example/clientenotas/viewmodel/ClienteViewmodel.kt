package com.example.clientenotas.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.clientenotas.data.local.Cliente
import com.example.clientenotas.data.local.ClienteConNotas
import com.example.clientenotas.repository.ClienteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClienteViewmodel(private val clienteRepository: ClienteRepository): ViewModel() {

    val clientes = clienteRepository.allClientes.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500),
        initialValue = emptyList()
    )

    private val _clienteConNotas = MutableStateFlow<ClienteConNotas?>(null)
    val clienteConNotas: StateFlow<ClienteConNotas?> = _clienteConNotas

    private val _cliente = MutableStateFlow<Cliente?>(null)
    val cliente: StateFlow<Cliente?> = _cliente

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

    fun VMgetClienteConNotas(clienteId: Int) {
        viewModelScope.launch {
            clienteRepository.getClienteConNotas(clienteId)
                .collect { resultado ->
                    _clienteConNotas.value = resultado
                }
        }
    }

    fun VMgetClienteById(id: Int) {
        viewModelScope.launch {
            _cliente.value = clienteRepository.getClienteById(id)
        }
    }
}

class ClienteViewModelFactory(private val repository: ClienteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ClienteViewmodel(repository) as T
    }
}