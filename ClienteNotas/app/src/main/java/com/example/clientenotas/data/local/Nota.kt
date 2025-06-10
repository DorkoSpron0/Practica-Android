package com.example.clientenotas.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

// -> N:1
@Entity(tableName = "nota_TABLE",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["clienteId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["clienteId"])]
)
data class Nota (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val contenido: String,
    val fecha: String,
    val clienteId: Int
)
