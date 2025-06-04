package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel() {

    var isDark by mutableStateOf(false)
}