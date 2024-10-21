package com.notsatria.sepathu.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.ui.commons.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CartViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<ShoeEntity>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ShoeEntity>>> get() = _uiState

    fun getShoesOnCart() {
        viewModelScope.launch(Dispatchers.IO) {
            shoeRepository.getShoesOnCart().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect {
                _uiState.value = UiState.Success(it)
            }
        }
    }

    fun removeShoesFromCart(shoeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            shoeRepository.updateShoeOnCart(shoeId, false)
        }
    }
}