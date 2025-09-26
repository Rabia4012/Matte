package com.example.matte.ui.komponenter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme

@Composable
fun QuestionSection(
    question: String,
    userInput: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = question,
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 36.sp // Ekstra stor for regnestykke
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = userInput.ifEmpty { "🤔" },
            style = MaterialTheme.typography.displayLarge,
            fontSize = 48.sp // Ekstra stor for svaret
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}