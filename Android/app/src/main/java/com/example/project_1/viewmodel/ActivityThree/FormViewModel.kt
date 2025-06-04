package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    var isNameValid by mutableStateOf(false)
    var isEmailValid by mutableStateOf(false)
    var isPasswordValid by mutableStateOf(false)
    var isConfirmPasswordValid by mutableStateOf(false)
}