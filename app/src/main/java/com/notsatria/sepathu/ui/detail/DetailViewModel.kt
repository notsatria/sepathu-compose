package com.notsatria.sepathu.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.ui.commons.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<ShoeEntity>>(UiState.Loading)
    val uiState get() = _uiState

    fun getShoeById(shoeId: Int) {
        viewModelScope.launch {
            shoeRepository.getShoeById(shoeId).catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collectLatest { shoe ->
                _uiState.value = UiState.Success(shoe)
            }
        }
    }

    fun addToCart(shoeId: Int, isOnCart: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            shoeRepository.updateShoeOnCart(shoeId, isOnCart)
        }
    }
}