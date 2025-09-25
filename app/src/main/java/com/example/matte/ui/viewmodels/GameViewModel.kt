package com.example.matte.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.matte.R
class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        // Les antall spørsmål fra SharedPreferences
        val sharedPreferences = getApplication<Application>()
            .getSharedPreferences("game_prefs", Context.MODE_PRIVATE)
        val gameLength = sharedPreferences.getInt("game_length", 5)

        val allQuestions = getApplication<Application>().resources.getStringArray(R.array.questions).toList()
        val allAnswers = getApplication<Application>().resources.getStringArray(R.array.answers).toList()

        // Velg tilfeldige spørsmål basert på valgt antall
        val randomIndices = allQuestions.indices.shuffled().take(gameLength)
        val selectedQuestions = randomIndices.map { allQuestions[it] }
        val selectedAnswers = randomIndices.map { allAnswers[it] }

        _uiState.value = GameUiState(
            questions = selectedQuestions,
            answers = selectedAnswers,
            currentQuestion = selectedQuestions.first(),
            correctAnswer = selectedAnswers.first(),
            totalQuestions = gameLength
        )
    }

    fun onNumberClick(number: String) {
        _uiState.value = _uiState.value.copy(
            userInput = _uiState.value.userInput + number
        )
    }

    fun onDeleteClick() {
        _uiState.value = _uiState.value.copy(
            userInput = _uiState.value.userInput.dropLast(1)
        )
    }

    fun onSubmitClick() {
        val isCorrect = _uiState.value.userInput == _uiState.value.correctAnswer
        _uiState.value = _uiState.value.copy(
            showDialog = true,
            lastCorrect = isCorrect
        )
    }

    fun onDialogDismiss() {
        val nextIndex = _uiState.value.currentIndex + 1

        if (nextIndex < _uiState.value.questions.size) {
            _uiState.value = _uiState.value.copy(
                currentIndex = nextIndex,
                currentQuestion = _uiState.value.questions[nextIndex],
                correctAnswer = _uiState.value.answers[nextIndex],
                userInput = "",
                showDialog = false
            )
        } else {
            _uiState.value = _uiState.value.copy(
                showDialog = false,
                gameCompleted = true
            )
        }
    }

    fun showCancelDialog() {
        _uiState.value = _uiState.value.copy(showCancelDialog = true)
    }

    fun hideCancelDialog() {
        _uiState.value = _uiState.value.copy(showCancelDialog = false)
    }

    fun resetGame() {
        _uiState.value = GameUiState()
        loadQuestions()
    }
}

data class GameUiState(
    val questions: List<String> = emptyList(),
    val answers: List<String> = emptyList(),
    val currentQuestion: String = "",
    val correctAnswer: String = "",
    val userInput: String = "",
    val currentIndex: Int = 0,
    val totalQuestions: Int = 0,
    val showDialog: Boolean = false,
    val lastCorrect: Boolean? = null,
    val gameCompleted: Boolean = false,
    val showCancelDialog: Boolean = false
)