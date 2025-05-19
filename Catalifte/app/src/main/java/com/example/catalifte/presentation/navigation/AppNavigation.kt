package com.example.catalift.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.catalift.presentation.screens.courses.CoursesScreen
import com.example.catalift.presentation.screens.explore.ExploreScreen
import com.example.catalift.presentation.screens.home.HomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigate = { route ->
                navController.navigate(route) {
                    popUpTo("home") { inclusive = route == "home" }
                }
            })
        }

        composable("explore") {
            ExploreScreen(onNavigate = { route ->
                navController.navigate(route) {
                    popUpTo("home")
                }
            })
        }

        composable("courses") {
            CoursesScreen(onNavigate = { route ->
                navController.navigate(route) {
                    popUpTo("home")
                }
            })
        }
    }
}