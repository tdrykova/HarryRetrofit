package com.tatry.harryretrofit.domain.usecase

import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.repository.CharacterRepository

class GetCharacterListUseCase(private val repo: CharacterRepository) {
    suspend fun getCharacterList(): List<CharacterModel> {
        return repo.getCharacters()
    }
}