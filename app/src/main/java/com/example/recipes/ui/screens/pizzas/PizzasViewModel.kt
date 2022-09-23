package com.example.recipes.ui.screens.pizzas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.PizzasRepository
import kotlinx.coroutines.launch

class PizzasViewModel: ViewModel() {

    var state by mutableStateOf(UiState())
    private set


    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(items = PizzasRepository.getPizzas())
        }
    }

    data class UiState(val loading: Boolean = false, val items: List<Pizza> = emptyList())
}