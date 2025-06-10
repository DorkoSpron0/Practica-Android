package com.example.clientenotas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cliente::class, Nota::class], version = 2, exportSchema = false) // Cambiar con el minimo cambio
abstract class AppDatabase : RoomDatabase(){
    abstract fun clienteDao(): ClienteDao
    abstract fun noteDao(): NotaDao

    companion object {
        @Volatile // Ese elemento cambia mediante la configuración
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "CLIENTE_NOTAS_DATABASE"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}