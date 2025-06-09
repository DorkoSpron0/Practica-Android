package com.example.proyecto_rom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyecto_rom.data.ToDoDatabase
import com.example.proyecto_rom.repository.ToDoRepository
import com.example.proyecto_rom.ui.screen.ToDoScreen
import com.example.proyecto_rom.ui.theme.Proyecto_RomTheme
import com.example.proyecto_rom.ui.viewmodel.ToDoViewmodel
import com.example.proyecto_rom.ui.viewmodel.TodoViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = ToDoDatabase.getDatabase(this).todoDao()
        val repository = ToDoRepository(dao)
        val factory = TodoViewModelFactory(repository)

        enableEdgeToEdge()
        setContent {
            Proyecto_RomTheme {
                Greeting("nicky")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto_RomTheme {
        Greeting("Android")
    }
}