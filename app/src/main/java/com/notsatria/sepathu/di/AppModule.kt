package com.notsatria.sepathu.di

import androidx.room.Room
import com.notsatria.sepathu.data.room.ShoeDatabase
import com.notsatria.sepathu.repository.ShoeRepository
import com.notsatria.sepathu.MainViewModel
import com.notsatria.sepathu.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
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

val repositoryModule = module {
    single { ShoeRepository(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}