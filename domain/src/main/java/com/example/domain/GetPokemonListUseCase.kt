package com.example.domain

import com.example.model.model.PokeDexException
import com.example.model.response.PokemonListResponse
import com.example.repository.PokemonListRepository
import com.github.michaelbull.result.Result

interface GetPokemonListUseCase {

    //TODO APIレスポンスをViewで使うModelにTranslatorを介して返還する

    /**
     * ポケモンリストを取得する
     *
     * @return return ポケモンリスト情報
     */
    suspend fun pokemonList(): Result<PokemonListResponse, PokeDexException>
}

internal class GetPokemonListUseCaseImpl(
    private val pokemonListRepository: PokemonListRepository
) : GetPokemonListUseCase {

    override suspend fun pokemonList() = pokemonListRepository.pokemonList()
}
