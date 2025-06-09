package com.example.proyecto_rom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TODO_TABLE")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val isDone: Boolean = false
)