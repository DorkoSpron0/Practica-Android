package com.example.project_1.view.transitions

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MyNavigationTransitions(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "vista1",
        enterTransition = {
            slideInHorizontally (
                initialOffsetX = {it},
            ) + fadeIn(
                animationSpec = tween(200)
            )
        }
    ){
        composable("vista1"){ Vista1(navController) }
        composable(
            route = "vista2/{nombre}",
            arguments = listOf(navArgument("nombre") {
                defaultValue = "defecto"
                type = NavType.StringType
            })
        ) {data ->
            val nombre = data.arguments?.getString("nombre")
            Vista2(
                navController,
                nombre = nombre
            )
        }
    }
}