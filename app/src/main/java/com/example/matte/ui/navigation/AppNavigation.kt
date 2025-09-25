package com.example.matte.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matte.ui.screens.MainScreen
import com.example.matte.ui.screens.GameScreen
import com.example.matte.ui.screens.AboutScreen
import com.example.matte.ui.screens.PreferencesScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable("game") {
            GameScreen(navController = navController)
        }

        composable("about") {
            AboutScreen(navController = navController)
        }
        composable("preferences") {
            PreferencesScreen(navController = navController)
        }
    }
}