package com.example.recipes.ui.screens.burgers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.entities.Burger
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.repositories.BurgersRepository
import com.example.recipes.data.repositories.PizzasRepository
import com.example.recipes.ui.navigation.NArgs
import kotlinx.coroutines.launch

class BurgersDetailViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    private val burgerId = savedStateHandle.get<Int>(NArgs.ItemId.key) ?: 0

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(burger = BurgersRepository.getBurgers().first { it.id == burgerId } )
        }
    }

    data class UiState(val loading: Boolean = false, val burger: Burger? = null){}
}