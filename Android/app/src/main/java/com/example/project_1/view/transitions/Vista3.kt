package com.example.project_1.view.transitions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ViewModel2

@Composable
fun Formulario(viewModel2: ViewModel2 = viewModel()){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
            Column(
                modifier = Modifier.padding(horizontal = 30.dp),
            ) {
                OutlinedTextField(
                    value = viewModel2.nombre.value,
                    onValueChange = {viewModel2.nombre.value = it},
                    label = { Text("Ingrese su nombre") }
                )
                OutlinedTextField(
                    value = viewModel2.edad.value,
                    onValueChange = {viewModel2.edad.value = it},
                    label = { Text("Ingrese su edad") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )

                Slider(
                    value = viewModel2.altura.toFloat(),
                    onValueChange = {viewModel2.altura = it.toInt()},
                    valueRange = 0f .. 200f,
                    steps = 200,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(viewModel2.altura.toString())

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = viewModel2.terminos.value,
                        onCheckedChange = {viewModel2.terminos.value = it},
                    )
                    Text("Aceptas los terminos?")
                }

                repeat(viewModel2.generos.size){ index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = viewModel2.genero == viewModel2.generos[index],
                            onClick = {viewModel2.genero = viewModel2.generos[index]}
                        )
                        Text(viewModel2.generos[index])
                    }
                }
                Text(viewModel2.genero)

                Button(
                    enabled = viewModel2.terminos.value && viewModel2.genero.isNotEmpty(),
                    onClick = {viewModel2.guardar()}
                ) {
                    Text("Guardar")
                }
            }
        }
    }