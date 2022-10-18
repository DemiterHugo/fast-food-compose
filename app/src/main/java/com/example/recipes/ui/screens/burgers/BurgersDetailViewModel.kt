package com.example.recipes.ui.screens.burgers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import arrow.core.right
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.BurgersRepository
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.navigation.NArgs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BurgersDetailViewModel(savedStateHandle: SavedStateHandle, burgersRepository: BurgersRepository): ViewModel() {

    private val burgerId = savedStateHandle.get<Int>(NArgs.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(burger = burgersRepository.findBurgerById(burgerId) )
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val burger: Ei<Burger?> = Either.Right(null)
    ){}
}