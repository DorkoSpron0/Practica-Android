package com.example.project_1.viewmodel.ActivityThree

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EmailValidatorViewModel: ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var emailIsValid by mutableStateOf(false)
    var passwordIsValid by mutableStateOf(false)
}