package com.notsatria.sepathu.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.ui.commons.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ShoeEntity>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ShoeEntity>>> get() = _uiState

    var searchQuery by mutableStateOf("")
        private set

    fun updateQuery(input: String) {
        searchQuery = input
    }

    fun searchShoes(query: String = "a") {
        viewModelScope.launch(Dispatchers.IO) {
            shoeRepository.searchShoes(query).catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collectLatest {
                _uiState.value = UiState.Success(it)
            }
        }
    }

    fun updateShoeOnCart(shoeId: Int, isOnCart: Boolean) {
        if (_uiState.value !is UiState.Success) return
        val updatedShoes = (_uiState.value as UiState.Success<List<ShoeEntity>>).data.map { shoe ->
            if (shoe.id == shoeId) shoe.copy(isOnCart = isOnCart) else shoe
        }
        _uiState.value = UiState.Success(updatedShoes)
    }

}