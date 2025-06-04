package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.R
import com.example.project_1.viewmodel.ActivityThree.EmailIconViewModel

@Composable
fun EmailIcon(emailViewModel: EmailIconViewModel = viewModel()){
/*
*
* Objetivo: Mostrar ícono o al escribir un correo válido o inválido.
- TextField para email.
- Mostrar ícono verde/rojo a la derecha del campo según validez.
- Se actualiza en tiempo real con State.
*
* */

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = emailViewModel.email,
                onValueChange = {input ->
                    emailViewModel.email = input
                    emailViewModel.isEmailValid = emailViewModel.email.isNotEmpty() && emailViewModel.email.isNotBlank()
                },
                label = { Text("Ingrese su email")

                },
                isError = !emailViewModel.isEmailValid
            )

            if(emailViewModel.isEmailValid){
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done"
                )
            }else{
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Done"
                )
            }
        }
    }
}