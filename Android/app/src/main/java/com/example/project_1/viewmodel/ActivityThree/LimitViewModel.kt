package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LimitViewModel: ViewModel() {

    var text by mutableStateOf("")
    var isLengthValue by mutableStateOf(true)
}