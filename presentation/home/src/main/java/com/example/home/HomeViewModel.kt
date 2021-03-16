package com.example.home

import androidx.lifecycle.*
import com.example.domain.GetPokemonListUseCase
import com.example.model.model.PokeDexException
import com.example.model.response.PokemonListResponse
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel(), LifecycleObserver {

    data class UiModel(
        var error: PokeDexException?,
        val pokemonListResponse: PokemonListResponse
    ) {
        companion object {
            val EMPTY = UiModel(null, PokemonListResponse(0, null, null, listOf()))
        }
    }

    private val _model = MediatorLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent() {
        viewModelScope.launch {
            when (val result = getPokemonListUseCase.pokemonList()) {
                is Ok -> {
                    _model.value = UiModel(null, result.value)
                }
                is Err -> {
                    _model.value = UiModel(result.error, PokemonListResponse(0, null, null, listOf()))
                }
            }
        }

    }
}
