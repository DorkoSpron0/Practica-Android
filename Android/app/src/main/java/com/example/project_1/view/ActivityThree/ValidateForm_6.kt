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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.FormViewModel

@Composable
fun ValidateForm(formViewModel: FormViewModel = viewModel()){
/*
*
* Objetivo: Validar varios campos con feedback visual.
- Nombre (no vacío), Correo, Contraseña, Confirmar contraseña.
- Si hay error, mostrar texto de ayuda y cambiar borde a rojo.
- Habilitar botón solo si todo es válido.
*
* */

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = formViewModel.name,
            onValueChange = {input ->
                formViewModel.name = input
                formViewModel.isNameValid = formViewModel.name.isNotEmpty() && formViewModel.name.isNotBlank()
            },
            label = { Text("Ingrese el nombre") },
            isError = !formViewModel.isNameValid
        )
        OutlinedTextField(
            value = formViewModel.email,
            onValueChange = {input ->
                formViewModel.email = input
                formViewModel.isEmailValid = input.isNotEmpty()
                        && input.contains("@")
                        && input.contains(".com")
            },
            label = { Text("Ingrese el email") },
            isError = !formViewModel.isEmailValid
        )
        OutlinedTextField(
            value = formViewModel.password,
            onValueChange = {input ->
                formViewModel.password = input
                formViewModel.isPasswordValid = formViewModel.password.isNotEmpty() && formViewModel.password.isNotBlank()
            },
            label = { Text("Ingrese el password") },
            isError = !formViewModel.isPasswordValid
        )
        OutlinedTextField(
            value = formViewModel.confirmPassword,
            onValueChange = {input ->
                formViewModel.confirmPassword = input
                formViewModel.isConfirmPasswordValid = formViewModel.confirmPassword == formViewModel.password
            },
            label = { Text("Confirme su contraseña") },
            isError = !formViewModel.isConfirmPasswordValid
        )

        Button(
            onClick = {},
            enabled = formViewModel.isNameValid
                    && formViewModel.isEmailValid
                    && formViewModel.isPasswordValid
                    && formViewModel.isConfirmPasswordValid
        ) { Text("Ingresar") }

        if(!formViewModel.isNameValid){
            Text(text = "Por favor valida tus credenciales",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if(!formViewModel.isEmailValid){
            Text(text = "Por favor valida tus credenciales, el correo debe incluir @, .com y no puede estar vacío",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if(!formViewModel.isPasswordValid){
            Text(text = "Por favor valida tus credenciales, la contraseña no puede estar vacía y debe tener un minimo de 6 caráctees",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(20.dp))

        if(!formViewModel.isConfirmPasswordValid){
            Text(text = "Por favor valida tus credenciales, las contraseñas no coinciden",
                color = Color.Red,
                textAlign = TextAlign.Center)
        }
    }
}