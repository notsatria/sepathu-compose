package com.notsatria.sepathu.ui.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.repository.ShoeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    private var _shoes = mutableStateListOf<ShoeEntity>()
    val shoes: List<ShoeEntity> = _shoes

    init {
        getAllShoes()
    }

    private fun getAllShoes() {
        viewModelScope.launch {
            shoeRepository.getAllShoes().collect { shoes ->
                _shoes.addAll(shoes)
            }
        }
    }
}