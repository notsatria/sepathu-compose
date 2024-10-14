package com.notsatria.sepathu.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notsatria.sepathu.data.entities.ShoeEntity

@Database(entities = [ShoeEntity::class], version = 1)
abstract class ShoeDatabase : RoomDatabase() {
    abstract fun dao(): ShoeDao
}