package com.example.proyecto_rom.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyecto_rom.ui.viewmodel.ToDoViewmodel

@Composable
fun ToDoScreen(viewModel: ToDoViewmodel){
    val todos by viewModel.todos.collectAsState();
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                label = { Text("Title") },
                value = title,
                onValueChange = {input -> title = input}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                label = { Text("Description") },
                value = description,
                onValueChange = {input -> description = input}
            )

            Button(
                modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
                onClick = {
                    viewModel.addTodo(title, description)
                }
            ) { Text("New Task") }
        }


        LazyColumn {
            items(todos.size) {
                val todo = todos[it]
                Row {
                    Text(text = todo.title)
                    Text(text = todo.description)
                    Button(
                        onClick = {
                            viewModel.deleteTodo(todo)
                        }
                    ) { Text("Remove Task") }
                }
            }
        }
    }
}