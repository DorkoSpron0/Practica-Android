package com.example.clientenotas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliente_TABLE")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val correo: String
)