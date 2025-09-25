package com.example.matte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.matte.ui.komponenter.*
import com.example.matte.ui.viewmodels.GameViewModel
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(navController: NavController) {
    val viewModel: GameViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GameTopBar(
            onBackClick = { viewModel.showCancelDialog() }
        )

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