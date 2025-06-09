package com.example.proyecto_rom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM TODO_TABLE")
    fun getAll(): Flow<List<ToDo>> // Es otro tipo de datos que envuelve la lista

    @Insert(onConflict = OnConflictStrategy.REPLACE) // verifica si el id existe, si existe lo remplaza sino lo añade
    suspend fun insert(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)
}