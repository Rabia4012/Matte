package com.example.matte.ui.komponenter

import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matte.R

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
                    text = if (isCorrect == true) stringResource(R.string.correct)
                    else stringResource(R.string.wrong),
                    fontSize = 20.sp
                )
            },
            text = {
                if (isCorrect != true) {
                    Text(
                        text = stringResource(R.string.correct_answer_was, correctAnswer),
                        fontSize = 18.sp
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.height(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.OK),
                        fontSize = 18.sp
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
            title = { Text(stringResource(R.string.confirm_quit)) },
            text = { Text(stringResource(R.string.quit_message)) },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text(stringResource(R.string.yes))
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text(stringResource(R.string.no))
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
            title = { Text(stringResource(R.string.game_completed)) },
            text = { Text(stringResource(R.string.game_completed_message)) },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text(stringResource(R.string.OK))
                }
            }
        )
    }
}