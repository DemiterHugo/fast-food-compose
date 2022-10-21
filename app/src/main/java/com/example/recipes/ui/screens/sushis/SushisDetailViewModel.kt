package com.example.recipes.ui.screens.sushis

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.recipes.data.database.Sushi
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.SushisRepository
import com.example.recipes.ui.navigation.NArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SushisDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle, private val sushisRepository: SushisRepository): ViewModel() {

    private val sushiId = savedStateHandle.get<Int>(NArgs.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(sushi = sushisRepository.findSushiById(sushiId))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val sushi: Ei<Sushi?> = Either.Right(null)
    )
}