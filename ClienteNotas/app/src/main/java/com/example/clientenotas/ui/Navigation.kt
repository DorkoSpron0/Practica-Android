package com.example.clientenotas.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clientenotas.data.local.AppDatabase
import com.example.clientenotas.repository.ClienteRepository
import com.example.clientenotas.ui.cliente.ClientListScreen
import com.example.clientenotas.ui.cliente.ClienteFormScreen
import com.example.clientenotas.ui.nota.NotaFormScreen
import com.example.clientenotas.ui.nota.NotaListScreen
import com.example.clientenotas.viewmodel.ClienteViewModelFactory
import com.example.clientenotas.viewmodel.ClienteViewmodel
import com.example.clientenotas.viewmodel.NotaViewModel

@Composable
fun MyNavigationTransitions(clienteViewModel: ClienteViewmodel, notaViewModel: NotaViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "clienteForm"
    ) {
        composable("clienteForm") {
            ClienteFormScreen(
                navController = navController,
                viewModel = clienteViewModel
            )
        }

        composable("clientList") {
            ClientListScreen(
                navController = navController,
                viewModel = clienteViewModel
            )
        }

        composable("notasForm") {
            NotaFormScreen(
                navController = navController,
                notaViewModel = notaViewModel
            )
        }

        composable("notasList") {
            NotaListScreen(
                navController = navController,
                viewModel = notaViewModel
            )
        }
    }
}
