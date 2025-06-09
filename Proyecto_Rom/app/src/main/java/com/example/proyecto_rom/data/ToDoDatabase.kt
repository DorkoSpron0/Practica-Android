package com.example.proyecto_rom.data

import androidx.room.Database
import androidx.room.Room
import android.content.Context
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1) // Cambiar con el minimo cambio
abstract class ToDoDatabase : RoomDatabase(){
    abstract fun todoDao(): ToDoDao

    companion object {
        @Volatile // Ese elemento cambia mediante la configuración
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "TODO_DATABASE"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}