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
import kotlinx.coroutines.launch

class SushisViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
    private set


    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(items = SushisRepository.getSushis())
        }
    }

    data class UiState(val loading: Boolean = false, val items: List<Sushi> = emptyList())
}