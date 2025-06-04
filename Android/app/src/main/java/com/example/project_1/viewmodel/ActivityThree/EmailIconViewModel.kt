package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EmailIconViewModel: ViewModel() {

    var email by mutableStateOf("")
    var isEmailValid by mutableStateOf(false)
}