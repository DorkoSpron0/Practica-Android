package com.example.proyecto_rom.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.proyecto_rom.data.ToDo
import com.example.proyecto_rom.repository.ToDoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// Intermediario entre la logica y las screens
class ToDoViewmodel(private val repository: ToDoRepository) : ViewModel() {
    val todos = repository.allToDos.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addTodo(title: String, description: String){
        val newTodo = ToDo(title = title, description = description)
        viewModelScope.launch {
            repository.insert(newTodo)
        }
    }

    fun deleteTodo(todo: ToDo){
        viewModelScope.launch {
            repository.delete(todo)
        }
    }
}

class TodoViewModelFactory(private val repository: ToDoRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ToDoViewmodel(repository) as T
    }
}