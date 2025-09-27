package com.example.matte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.matte.ui.komponenter.*
import com.example.matte.ui.viewmodels.GameViewModel
import com.example.matte.R

@Composable
fun GameScreen(navController: NavController) {
    val viewModel: GameViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { viewModel.showCancelDialog() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            QuestionSection(
                question = state.currentQuestion,
                userInput = state.userInput
            )

            NumberPad(
                onNumberClick = viewModel::onNumberClick,
                onDeleteClick = viewModel::onDeleteClick,
                onSubmitClick = viewModel::onSubmitClick
            )
        }
    }

    // Dialoger
    ResultDialog(
        showDialog = state.showDialog,
        isCorrect = state.lastCorrect,
        correctAnswer = state.correctAnswer,
        onDismiss = viewModel::onDialogDismiss
    )

    CancelDialog(
        showDialog = state.showCancelDialog,
        onConfirm = {
            viewModel.hideCancelDialog()
            navController.popBackStack()
        },
        onDismiss = viewModel::hideCancelDialog
    )

    GameCompletedDialog(
        showDialog = state.gameCompleted,
        onConfirm = {
            viewModel.resetGame()
            navController.popBackStack()
        }
    )
}