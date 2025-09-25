package com.example.matte.ui.komponenter

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

@Composable
fun NumberButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(4.dp)
            .size(70.dp)
    ) {
        Text(text)
    }
}