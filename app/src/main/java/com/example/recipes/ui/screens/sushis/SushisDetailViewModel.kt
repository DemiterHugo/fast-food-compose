package com.example.recipes.ui.screens.sushis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Sushi
import com.example.recipes.data.repositories.SushisRepository
import com.example.recipes.ui.navigation.NArgs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SushisDetailViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    private val sushiId = savedStateHandle.get<Int>(NArgs.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(sushi = SushisRepository.getSushis().first { it.id == sushiId } )
        }
    }

    data class UiState(val loading: Boolean = false, val sushi: Sushi? = null)
}