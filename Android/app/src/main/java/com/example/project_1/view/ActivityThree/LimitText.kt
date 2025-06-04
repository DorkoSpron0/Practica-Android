package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.LimitViewModel

@Composable
fun LimitText(limitViewModel: LimitViewModel = viewModel()){
/*
*
* Objetivo: Mostrar contador en tiempo real y cambiar color si se pasa.
- Límite de 100 caracteres.
- Contador abajo del campo (23/100).
- Si pasa los 100, texto del contador se pone en rojo.
*
* */


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = limitViewModel.text,
            onValueChange = {input ->
                limitViewModel.text = input
                limitViewModel.isLengthValue = if(limitViewModel.text.length < 100) true else false
            },
            isError = !limitViewModel.isLengthValue
        )

        Text(text = "${limitViewModel.text.length.toString()} / 100")
    }
}