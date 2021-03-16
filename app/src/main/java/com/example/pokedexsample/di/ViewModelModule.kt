package com.example.pokedexsample.di

import org.koin.dsl.module
import com.example.home.HomeViewModel

val viewModelModule = module {
    factory {
        HomeViewModel(
            getPokemonListUseCase = get()
        )
    }
}