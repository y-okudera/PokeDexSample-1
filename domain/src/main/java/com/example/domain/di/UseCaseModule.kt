package com.example.domain.di

import com.example.domain.GetPokemonListUseCase
import com.example.domain.GetPokemonListUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetPokemonListUseCaseImpl(
            pokemonListRepository = get()
        ) as GetPokemonListUseCase
    }
}
