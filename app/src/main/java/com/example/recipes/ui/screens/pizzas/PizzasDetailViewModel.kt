package com.example.recipes.ui.screens.pizzas

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.recipes.data.database.Pizza
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.navigation.NArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzasDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle, private val pizzasRepository: PizzasRepository): ViewModel() {

    private val pizzaId = savedStateHandle.get<Int>(NArgs.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(pizza = pizzasRepository.findPizzaById(pizzaId))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val pizza: Ei<Pizza?> = Either.Right(null)
    )
}