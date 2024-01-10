package com.tatry.harryretrofit.domain.usecase

import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.repository.CharacterRepository

class GetCharacterUseCase(private val repo: CharacterRepository) {
    suspend fun getCharacter(id: Int = 1) : CharacterModel {
        return repo.getCharacterById(id)
    }
}