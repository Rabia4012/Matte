package com.example.matte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matte.ui.screens.AboutScreen
import com.example.matte.ui.screens.GameScreen
import com.example.matte.ui.screens.MainScreen
import com.example.matte.ui.screens.PreferencesScreen
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.matte.ui.theme.MatteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()) {
                    NavigationGraph()
                }
            }
        }
    }
}

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("game") { GameScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("preferences") { PreferencesScreen(navController) }
    }
}