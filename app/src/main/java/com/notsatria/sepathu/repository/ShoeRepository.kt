package com.notsatria.sepathu.repository

import com.notsatria.sepathu.data.entities.ShoeEntity
import com.notsatria.sepathu.data.room.ShoeDao

class ShoeRepository(
    private val shoeDao: ShoeDao
) {
    fun getAllShoes() = shoeDao.getAllShoes()

    fun getShoeById(id: Int) = shoeDao.getShoeById(id)

    fun updateShoeOnCart(id: Int, isOnCart: Boolean) = shoeDao.updateShoeOnCart(id, isOnCart)

    fun getShoesOnCart() = shoeDao.getShoesOnCart()

    fun getShoesByCategory(categoryId: Int) = shoeDao.getShoesByCategory(categoryId)

    fun insertShoe(shoe: ShoeEntity) = shoeDao.insertShoe(shoe)
}