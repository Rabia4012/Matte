package com.example.matte.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PrefViewModel(application: Application) : AndroidViewModel(application) {
    // Game length - behold denne med SharedPreferences
    private val _gameLength = MutableStateFlow(5)
    val gameLength: StateFlow<Int> = _gameLength.asStateFlow()

    // Språk - BARE for visning, ingen lagring
    private val _currentLanguage = MutableStateFlow("no")
    val currentLanguage: StateFlow<String> = _currentLanguage.asStateFlow()

    private val sharedPreferences =
        application.getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

    init {
        // Bare last game length fra SharedPreferences
        _gameLength.value = sharedPreferences.getInt("game_length", 5)
    }

    fun setGameLength(length: Int) {
        sharedPreferences.edit().putInt("game_length", length).apply()
        _gameLength.value = length
    }

    // Språkfunksjon - ingen lagring til SharedPreferences
    fun setLanguage(languageCode: String) {
        _currentLanguage.value = languageCode
        // INGEN sharedPreferences.edit().putString() her!
    }
}