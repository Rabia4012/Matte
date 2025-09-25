package com.example.matte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.matte.R

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.app_name), style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("game") }){
            Text(stringResource(R.string.start_game))
        }

        Button(onClick = { navController.navigate("about") }){
            Text(stringResource(R.string.about))
        }

        Button(onClick = { navController.navigate("preferences") }){
            Text(stringResource(R.string.settings))
        }
    }
}