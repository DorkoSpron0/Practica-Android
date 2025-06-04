package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.ColorViewModel

@Composable
fun ThemeChanger(colorViewModel: ColorViewModel = viewModel()){

    /*
    *
    * Objetivo: Cambiar colores del fondo según el modo.
        - Botón que cambia entre tema claro y oscuro.
        - Guardar el estado en ViewModel.
        - Background cambia según modo.
    *
    * */

    var colorScheme = if(colorViewModel.isDark) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme
    ){
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ){
            Text("hola mundo")
            Button(
                onClick = {colorViewModel.isDark = !colorViewModel.isDark}
            ) { Text("Cambiar tema") }
        }
    }
}