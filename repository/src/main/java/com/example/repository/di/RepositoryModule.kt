package com.example.repository.di

import com.example.repository.PokemonListRepository
import com.example.repository.PokemonListRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        PokemonListRepositoryImpl(
            pokeApiClient = get()
        ) as PokemonListRepository
    }
}