package com.example.recipes.ui.screens.pizzas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.right
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.PizzasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PizzasViewModel(private val pizzasRepository: PizzasRepository): ViewModel() {

    /*var state by mutableStateOf(UiState())
    private set*/

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(items = pizzasRepository.getPizzas())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val items: Ei<List<Pizza>> = emptyList<Pizza>().right()
    )
}