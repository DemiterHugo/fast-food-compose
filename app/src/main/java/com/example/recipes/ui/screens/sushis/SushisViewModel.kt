package com.example.recipes.ui.screens.sushis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.right
import com.example.recipes.data.database.Sushi
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.SushisRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SushisViewModel @Inject constructor(private val sushisRepository: SushisRepository): ViewModel() {

    private var _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()



    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(items = sushisRepository.getSushis())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val items: Ei<List<Sushi>> = emptyList<Sushi>().right()
    )
}