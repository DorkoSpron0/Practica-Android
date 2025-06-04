package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.project_1.viewmodel.ViewModel2

class ContadorViewModel: ViewModel() {

    var numberIndex by mutableStateOf(0)
}