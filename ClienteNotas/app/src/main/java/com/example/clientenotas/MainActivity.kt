package com.example.clientenotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.clientenotas.data.local.AppDatabase
import com.example.clientenotas.data.local.ClienteDao
import com.example.clientenotas.repository.ClienteRepository
import com.example.clientenotas.repository.NotaRepository
import com.example.clientenotas.ui.MyNavigationTransitions
import com.example.clientenotas.ui.cliente.ClienteFormScreen
import com.example.clientenotas.ui.theme.ClienteNotasTheme
import com.example.clientenotas.viewmodel.ClienteViewModelFactory
import com.example.clientenotas.viewmodel.ClienteViewmodel
import com.example.clientenotas.viewmodel.NotaViewModel
import com.example.clientenotas.viewmodel.NotaViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val dao = AppDatabase.getDatabase(this).clienteDao()
        val repository = ClienteRepository(dao)
        val factory = ClienteViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[ClienteViewmodel::class.java]

        val daoNota = AppDatabase.getDatabase(this).noteDao()
        val repositoryNota = NotaRepository(daoNota)
        val factoryNota = NotaViewModelFactory(repositoryNota)
        val viewModelNota = ViewModelProvider(this, factoryNota)[NotaViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            ClienteNotasTheme {
                    MyNavigationTransitions(viewModel, viewModelNota)
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
    ClienteNotasTheme {
        Greeting("Android")
    }
}