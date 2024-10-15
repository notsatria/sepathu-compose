package com.notsatria.sepathu

import android.app.Application
import com.notsatria.sepathu.di.databaseModule
import com.notsatria.sepathu.di.repositoryModule
import com.notsatria.sepathu.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShoeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ShoeApp)
            modules(
                listOf(
                    databaseModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}