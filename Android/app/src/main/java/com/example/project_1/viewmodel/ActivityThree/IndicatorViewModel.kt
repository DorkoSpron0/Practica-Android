package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class IndicatorViewModel: ViewModel() {
    var password by mutableStateOf("")

    var colorIndicator by mutableStateOf(Color.Red)
}