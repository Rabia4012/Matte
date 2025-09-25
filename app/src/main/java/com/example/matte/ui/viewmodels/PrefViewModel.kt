package com.example.matte.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PrefViewModel(application: Application) : AndroidViewModel(application) {

    private val _gameLength = MutableStateFlow(5)
    val gameLength: StateFlow<Int> = _gameLength.asStateFlow()

    fun loadGameLength() {
        viewModelScope.launch {
            val sharedPreferences = getApplication<Application>()
                .getSharedPreferences("game_prefs", android.content.Context.MODE_PRIVATE)
            val length = sharedPreferences.getInt("game_length", 5)
            _gameLength.value = length
        }
    }

    fun setGameLength(length: Int) {
        viewModelScope.launch {
            val sharedPreferences = getApplication<Application>()
                .getSharedPreferences("game_prefs", android.content.Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("game_length", length).apply()
            _gameLength.value = length
        }
    }
}