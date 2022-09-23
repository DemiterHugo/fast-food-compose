package com.example.recipes.ui.screens.apples

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Apple
import com.example.recipes.data.repositories.ApplesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApplesViewModel: ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(apples = ApplesRepository.getApples())
            _state.value = UiState(apples = ApplesRepository.getApples(),names = ApplesRepository.getApples().map {
                it.name.split(" ").sortedBy { it.length }.last() })
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val apples: List<Apple> = emptyList(),
        val names: List<String> = emptyList()
    )
}