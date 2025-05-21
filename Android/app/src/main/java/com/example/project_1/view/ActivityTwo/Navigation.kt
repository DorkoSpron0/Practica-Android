package com.example.project_1.view.ActivityTwo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_1.view.ActivityOne.Register

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"){
            composable("home"){ Register(navController) }
            composable("info") { Info(navController) }
            composable("detalles") { Detalles(navController) }
            composable("register") { Register(navController) }
    }
}