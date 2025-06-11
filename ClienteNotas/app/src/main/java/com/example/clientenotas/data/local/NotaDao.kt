package com.example.clientenotas.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(nota: Nota)

    @Update
    suspend fun updateNota(nota: Nota)

    @Delete
    suspend fun delete(nota: Nota)

    @Query("SELECT * FROM nota_TABLE WHERE id = :id")
    fun getById(id: Int): Flow<Nota>

    @Query("SELECT * FROM nota_TABLE")
    fun getAll(): Flow<List<Nota>>

    @Transaction
    @Query("SELECT * FROM CLIENTE_TABLE WHERE id = :clienteId")
    suspend fun getNotasDeCliente(clienteId: Int): ClienteConNotas?
}