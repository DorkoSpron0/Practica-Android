package com.example.clientenotas.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clientenotas.ui.cliente.ClientListScreen
import com.example.clientenotas.ui.cliente.ClienteDetailsScreen
import com.example.clientenotas.ui.cliente.ClienteFormScreen
import com.example.clientenotas.ui.nota.NotaFormScreen
import com.example.clientenotas.ui.nota.NotaListScreen
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

        composable("clienteDetails/{clienteId}") { backStackEntry ->
            val clienteId = backStackEntry.arguments?.getString("clienteId")
            ClienteDetailsScreen(
                navController = navController,
                clienteViewmodel = clienteViewModel,
                clienteId = clienteId
            )
        }

    }
}
