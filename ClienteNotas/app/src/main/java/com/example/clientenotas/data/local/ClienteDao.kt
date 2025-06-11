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
interface ClienteDao {

    @Delete
    suspend fun delete(cliente: Cliente);

    @Update
    suspend fun updateCliente(cliente: Cliente);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cliente: Cliente);

    @Query("SELECT * FROM Cliente_TABLE ORDER BY id desc")
    fun getAll(): Flow<List<Cliente>>;

    @Query("DELETE FROM Cliente_TABLE WHERE id = :id")
    suspend fun deleteById(id: Int);

    @Transaction
    @Query("SELECT * FROM Cliente_TABLE WHERE id = :clienteId")
    fun getClienteConNotas(clienteId: Int): Flow<ClienteConNotas>

    @Query("SELECT * FROM Cliente_TABLE WHERE id = :id")
    suspend fun getById(id: Int): Cliente?
}