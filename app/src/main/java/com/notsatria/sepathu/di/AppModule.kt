package com.notsatria.sepathu.di

import androidx.room.Room
import com.notsatria.sepathu.data.room.ShoeDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<ShoeDatabase>().dao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ShoeDatabase::class.java,
            "Shoe.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}