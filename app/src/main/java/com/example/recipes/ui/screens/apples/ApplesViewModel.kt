package com.example.recipes.ui.screens.apples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Apple
import com.example.recipes.data.repositories.ApplesRepository
import kotlinx.coroutines.launch

class ApplesViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
    private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(apples = ApplesRepository.getApples())
            state = UiState(apples = ApplesRepository.getApples(),names = ApplesRepository.getApples().map {
                it.name.split(" ").sortedBy { it.length }.last() })
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val apples: List<Apple> = emptyList(),
        val names: List<String> = emptyList()
    )
}