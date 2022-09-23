package com.example.recipes.ui.screens.sushis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.entities.Sushi
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.data.repositories.SushisRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SushisViewModel: ViewModel() {

    private var _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()



    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(items = SushisRepository.getSushis())
        }
    }

    data class UiState(val loading: Boolean = false, val items: List<Sushi> = emptyList())
}