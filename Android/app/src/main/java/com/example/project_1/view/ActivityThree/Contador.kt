package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.ContadorViewModel

@Composable
fun Contador(contadorViewModel: ContadorViewModel = viewModel()){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = contadorViewModel.numberIndex.toString(),
            color = if(contadorViewModel.numberIndex % 2 == 0) Color.Green else Color.Red)

        Row {
            Button(
                onClick = {contadorViewModel.numberIndex++}
            ) {
                Text(" + ")
            }

            Button(
                onClick = {contadorViewModel.numberIndex--}
            ) {
                Text(" - ")
            }
        }
    }
}
