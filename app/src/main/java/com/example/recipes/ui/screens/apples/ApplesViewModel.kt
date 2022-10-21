package com.example.recipes.ui.screens.apples

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.right
import com.example.recipes.data.database.Apple
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.repositories.ApplesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplesViewModel @Inject constructor(private val applesRepository: ApplesRepository): ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(apples = applesRepository.getApples())
            _state.value = UiState(apples = applesRepository.getApples(),names = applesRepository.getNames())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val apples: Ei<List<Apple>> = emptyList<Apple>().right(),
        val names: Ei<List<String>> = emptyList<String>().right()
    )
}