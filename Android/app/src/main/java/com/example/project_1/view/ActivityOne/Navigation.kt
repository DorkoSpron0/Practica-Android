package com.example.project_1.view.ActivityOne

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project_1.HorizontalPages

@Composable
fun Navigation() {
    val navController = rememberNavController();

    NavHost(
        navController = navController,
        startDestination = "home"){
            composable("home"){ HorizontalPages(navController) }
            composable("register") { Register(navController) }
            composable("login") { Login(navController) }

    }
}