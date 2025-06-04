package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.EmailValidatorViewModel

@Composable
fun EmailValidator(emailViewModel: EmailValidatorViewModel = viewModel()){
    /*
    * Objetivo: Validar campos de usuario y contraseña.
        - Validar que el correo sea válido (@ y .com)
        - Contraseña de mínimo 6 caracteres.
        - Botón de 'Iniciar sesión' se activa solo si ambos son válidos.
        - Mostrar errores en rojo si están mal.
    * */

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = emailViewModel.email,
            onValueChange = {value ->
                emailViewModel.email = value
                emailViewModel.emailIsValid = value.isNotEmpty()
                        && value.contains("@")
                        && value.contains(".com")
            },
            label = { Text("Ingrese su email") },
            isError = !emailViewModel.emailIsValid
        )

        OutlinedTextField(
            value = emailViewModel.password,
            onValueChange = {value ->
                emailViewModel.password = value
                emailViewModel.passwordIsValid = value.isNotEmpty()
                        && value.length > 6
            },
            label = { Text("Ingrese su email")},
            visualTransformation = PasswordVisualTransformation(),
            isError = !emailViewModel.passwordIsValid
        )

        Button(
            onClick = {},
            enabled = emailViewModel.emailIsValid && emailViewModel.passwordIsValid
        ) { Text("Iniciar sesión") }

        if(!emailViewModel.emailIsValid){
            Text(text = "Por favor valida tus credenciales, el correo debe incluir @, .com y no puede estar vacío",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if(!emailViewModel.passwordIsValid){
            Text(text = "Por favor valida tus credenciales, la contraseña no puede estar vacía y debe tener un minimo de 6 caráctees",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }
    }


}