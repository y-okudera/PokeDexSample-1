package com.example.pokedexsample

import android.app.Application
import com.example.api.di.networkModule
import com.example.domain.di.useCaseModule
import com.example.pokedexsample.di.navigationModule
import com.example.pokedexsample.di.viewModelModule
import com.example.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule, navigationModule, networkModule, useCaseModule, repositoryModule
                )
            )
        }
    }
}
