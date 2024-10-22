package com.notsatria.sepathu.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shoe")
data class ShoeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Double,

    @ColumnInfo(name = "image")
    val image: Int,
    // 0: Running, 1: Walking, 2: Hiking, 3: Basketball
    @ColumnInfo(name = "category_id")
    val categoryId: Int,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "is_on_cart")
    var isOnCart: Boolean = false,
)