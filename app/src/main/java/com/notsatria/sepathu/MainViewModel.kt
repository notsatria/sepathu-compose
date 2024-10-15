package com.notsatria.sepathu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.utils.DataDummy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val shoeRepository: ShoeRepository) : ViewModel() {

    fun populateShoesData() {
        viewModelScope.launch(Dispatchers.IO) {
            DataDummy.generateDummyShoe().forEach { shoe ->
                shoeRepository.insertShoe(shoe)
            }
        }
    }
}