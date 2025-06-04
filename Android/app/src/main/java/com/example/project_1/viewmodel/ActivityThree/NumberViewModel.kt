package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NumberViewModel: ViewModel() {
    var number by mutableStateOf("")
    var numberIsValid by mutableStateOf(false)
}