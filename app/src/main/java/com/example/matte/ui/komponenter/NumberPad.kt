package com.example.matte.ui.komponenter

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumberPad(
    onNumberClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onSubmitClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Rad 1-3
        for (i in 0..2) {
            Row {
                for (j in 1..3) {
                    val number = (i * 3 + j).toString()
                    NumberButton(
                        text = number,
                        onClick = { onNumberClick(number) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Siste rad
        Row {
            NumberButton(
                text = "0",
                onClick = { onNumberClick("0") }
            )
            NumberButton(
                text = "Slett",
                onClick = onDeleteClick
            )
            NumberButton(
                text = "Svar",
                onClick = onSubmitClick
            )
        }
    }
}