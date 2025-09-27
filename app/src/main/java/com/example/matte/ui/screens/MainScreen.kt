package com.example.matte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.matte.R

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 50.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = { navController.navigate("game") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(70.dp)
            ) {
                Text(
                    text = stringResource(R.string.start_game),
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("about") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(70.dp)
            ) {
                Text(
                    text = stringResource(R.string.about),
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("preferences") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(70.dp)
            ) {
                Text(
                    text = stringResource(R.string.settings),
                    fontSize = 30.sp
                )
            }
        }
    }
}