package com.example.project_1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel2: ViewModel() {
    var nombre = mutableStateOf("")
    var edad = mutableStateOf("")
    var generos by mutableStateOf(listOf("Femenino", "Masculino"))
    var genero by mutableStateOf("")
    var terminos = mutableStateOf(false)

    var altura by mutableStateOf(0)

    fun guardar(){
        println("nombre ${nombre.value}")
        println("edad ${edad.value}")
    }
}