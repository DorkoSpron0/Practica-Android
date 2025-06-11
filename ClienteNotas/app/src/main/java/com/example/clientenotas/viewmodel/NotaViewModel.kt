package com.example.clientenotas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.clientenotas.data.local.ClienteConNotas
import com.example.clientenotas.data.local.Nota
import com.example.clientenotas.repository.NotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotaViewModel(private val notaRepository: NotaRepository): ViewModel() {

    val notas = notaRepository.allNotas.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500),
        initialValue = emptyList()
    )

    private val _clienteConNotas = MutableStateFlow<ClienteConNotas?>(null)
    val clienteConNotas: StateFlow<ClienteConNotas?> = _clienteConNotas

    fun VMinsert(contenido: String, fecha: String, clienteId: Int){
        val newNota = Nota(contenido = contenido, fecha = fecha, clienteId = clienteId)
        viewModelScope.launch {
            notaRepository.insert(newNota)
        }
    }

    fun VMupdateNota(nota: Nota){
        val notaUpdated = Nota(id = nota.id, contenido = nota.contenido, fecha = nota.fecha, clienteId = nota.clienteId)
        viewModelScope.launch {
            notaRepository.updateNota(notaUpdated)
        }
    }

    fun VMdelete(nota: Nota){
        viewModelScope.launch {
            notaRepository.delete(nota)
        }
    }

    fun VMgetById(id: Int){
        viewModelScope.launch {
            notaRepository.getById(id)
        }
    }

    fun VMgetNotasDeCliente(clienteId: Int){
        viewModelScope.launch {
            _clienteConNotas.value = notaRepository.getNotasDeCliente(clienteId)
        }
    }
}

class NotaViewModelFactory(private val repository: NotaRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotaViewModel(repository) as T
    }
}