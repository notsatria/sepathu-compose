package com.notsatria.sepathu.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeCategory
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.ui.commons.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ShoeEntity>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ShoeEntity>>> get() = _uiState

    private val _chipSelectedId = MutableStateFlow(4)
    val chipSelected: StateFlow<Int> = _chipSelectedId.asStateFlow()

    val shoeCategories = listOf(
        ShoeCategory(4, "All"),
        ShoeCategory(0, "Running"),
        ShoeCategory(1, "Walking"),
        ShoeCategory(2, "Casual"),
        ShoeCategory(3, "Basketball"),
    )

    fun setChipSelected(selectedId: Int) {
        _chipSelectedId.value = selectedId
    }

    fun getAllShoes() {
        viewModelScope.launch {
            shoeRepository.getAllShoes().catch {
                _uiState.value = UiState.Error(it.message.toString())
            }.collect { shoes ->
                _uiState.value = UiState.Success(shoes)
            }
        }
    }

    fun getShoesByCategory(categoryId: Int) {
        viewModelScope.launch {
            shoeRepository.getShoesByCategory(categoryId)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { shoes ->
                    _uiState.value = UiState.Success(shoes)
            }
        }
    }

    fun updateShoeOnCart(id: Int, isOnCart: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            shoeRepository.updateShoeOnCart(id, isOnCart)
        }
    }
}
