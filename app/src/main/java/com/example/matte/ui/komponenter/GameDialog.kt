package com.example.matte.ui.komponenter

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ResultDialog(
    showDialog: Boolean,
    isCorrect: Boolean?,
    correctAnswer: String,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(if (isCorrect == true) "Riktig!" else "Feil") },
            text = { Text("Svar: $correctAnswer") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun CancelDialog(
    showDialog: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Avbryt spillet?") },
            text = { Text("Vil du avbryte spillet?") },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text("Ja")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Nei")
                }
            }
        )
    }
}

@Composable
fun GameCompletedDialog(
    showDialog: Boolean,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Ferdig!") },
            text = { Text("Du har fullført spillet!") },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text("OK")
                }
            }
        )
    }
}