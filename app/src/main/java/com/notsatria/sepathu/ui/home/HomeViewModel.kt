package com.notsatria.sepathu.ui.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeCategory
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    private val _shoes = MutableStateFlow<List<ShoeEntity>>(emptyList())
    val shoes: StateFlow<List<ShoeEntity>> = _shoes.asStateFlow()

    private val _chipSelectedId = MutableStateFlow(4)
    val chipSelected: StateFlow<Int> = _chipSelectedId.asStateFlow()

    val shoeCategories = listOf(
        ShoeCategory(4, "All"),
        ShoeCategory(0, "Running"),
        ShoeCategory(1, "Walking"),
        ShoeCategory(2, "Casual"),
        ShoeCategory(3, "Formal"),
    )

    fun setChipSelected(selectedId: Int) {
        _chipSelectedId.value = selectedId
    }

    fun getAllShoes() {
        viewModelScope.launch {
            shoeRepository.getAllShoes().collect { shoes ->
                _shoes.value = shoes
            }
        }
    }

    fun getShoesByCategory(categoryId: Int) {
        viewModelScope.launch {
            shoeRepository.getShoesByCategory(categoryId).collectLatest { shoes ->
                _shoes.value = shoes
            }
        }
    }
}
