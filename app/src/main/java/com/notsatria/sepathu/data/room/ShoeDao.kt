package com.notsatria.sepathu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.notsatria.sepathu.data.entities.ShoeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertShoe(shoe: ShoeEntity)

    @Query("SELECT * FROM shoe")
    fun getAllShoes(): Flow<List<ShoeEntity>>

    @Query("SELECT * FROM shoe WHERE id = :id")
    fun getShoeById(id: Int): Flow<ShoeEntity>

    @Query("UPDATE shoe SET is_on_cart = :isOnCart WHERE id = :id")
    fun updateShoeOnCart(id: Int, isOnCart: Boolean)

    @Query("SELECT * FROM shoe WHERE is_on_cart = 1")
    fun getShoesOnCart(): Flow<List<ShoeEntity>>

    @Query("SELECT * FROM shoe WHERE category_id = :categoryId")
    fun getShoesByCategory(categoryId: Int): Flow<List<ShoeEntity>>

}