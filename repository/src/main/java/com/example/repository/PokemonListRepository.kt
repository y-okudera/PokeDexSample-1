package com.example.repository

import com.example.api.client.PokeApiClient
import com.example.model.model.EmptyResponseBodyException
import com.example.model.model.PokeDexException
import com.example.model.response.PokemonListResponse
import com.github.michaelbull.result.*

interface PokemonListRepository {

    //TODO APIレスポンスをViewで使うModelにTranslatorを介して返還する

    /**
     * ポケモンリストを取得する
     *
     * @return return ポケモンリスト情報
     */
    suspend fun pokemonList(): Result<PokemonListResponse, PokeDexException>
}

internal class PokemonListRepositoryImpl(
    private val pokeApiClient: PokeApiClient
) : PokemonListRepository {

    override suspend fun pokemonList(): Result<PokemonListResponse, PokeDexException> {
        return pokeApiClient.fetchPokemonList().flatMap {
            if (it != null) {
                Ok(it)
            } else {
                Err(EmptyResponseBodyException())
            }
        }
    }
}
