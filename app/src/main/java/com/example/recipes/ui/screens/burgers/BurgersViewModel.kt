package com.example.recipes.ui.screens.burgers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.right
import com.example.recipes.data.database.Burger
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.BurgersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BurgersViewModel @Inject constructor(private val burgersRepository: BurgersRepository): ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(items = burgersRepository.getBurgers())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val items: Ei<List<Burger>> = emptyList<Burger>().right()
    )
}