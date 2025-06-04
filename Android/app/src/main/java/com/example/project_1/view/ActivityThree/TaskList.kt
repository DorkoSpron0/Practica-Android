package com.example.project_1.view.ActivityThree

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.project_1.viewmodel.ActivityThree.TaskListViewModel

@Composable
fun TaskList(taskListViewModel: TaskListViewModel = viewModel()){
/*
*
* Objetivo: Cada tarea tiene un estado (pendiente, hecho).
- Lista de tareas desde ViewModel.
- Checkbox que actualiza el estado de la tarea.
- Cambiar color de fondo de la tarjeta si está completa.
*
* */

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(taskListViewModel.listaTares.size) { index ->
            val task = taskListViewModel.listaTares[index]

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (task.completado) Color.Green else Color.White)
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(task.id.toString())
                Text(task.nombre)
                Text(task.completado.toString())
                Checkbox(
                    checked = task.completado,
                    onCheckedChange = {task.completado = !task.completado},
                )
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}