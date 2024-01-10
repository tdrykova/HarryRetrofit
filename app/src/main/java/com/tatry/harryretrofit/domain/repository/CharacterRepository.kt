package com.tatry.harryretrofit.domain.repository

import com.tatry.harryretrofit.domain.model.CharacterModel

interface CharacterRepository {
    suspend fun getCharacters() : List<CharacterModel>
    suspend fun getCharacterById(id: Int) : CharacterModel
}