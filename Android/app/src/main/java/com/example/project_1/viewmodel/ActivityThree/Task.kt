package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(
    val id: Int,
    val nombre: String,
    completado: Boolean
) {
    var completado by mutableStateOf(completado)
}