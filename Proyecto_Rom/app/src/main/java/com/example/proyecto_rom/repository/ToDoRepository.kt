package com.example.proyecto_rom.repository

import com.example.proyecto_rom.data.ToDo
import com.example.proyecto_rom.data.ToDoDao
import com.example.proyecto_rom.data.ToDoDatabase
import kotlinx.coroutines.flow.Flow

class ToDoRepository(private val dao: ToDoDao) {
    val allToDos:Flow<List<ToDo>> = dao.getAll()

    suspend fun insert(todo: ToDo){
        dao.insert(todo)
    }

    suspend fun delete(todo: ToDo){
        dao.delete(todo)
    }
}