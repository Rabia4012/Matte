package com.example.matte.ui.komponenter

import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
            title = {
                Text(
                    text = if (isCorrect == true) "Riktig, bra jobbet! 🎉"
                    else "Feil, prøv igjen 😊",
                    fontSize = 20.sp // Større tittel
                )
            },
            text = {
                if (isCorrect != true) {
                    Text(
                        text = "Riktig svar var: $correctAnswer",
                        fontSize = 18.sp // Større tekst for riktig svar
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.height(50.dp) // Større knapp
                ) {
                    Text(
                        text = "OK",
                        fontSize = 18.sp // Større knappetekst
                    )
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