package com.tatry.harryretrofit.data.network

import com.tatry.harryretrofit.data.network.dto.CharacterDto
import com.tatry.harryretrofit.data.network.mapper.CharacterMapper
import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.repository.CharacterRepository

class CharacterRepositoryImpl : CharacterRepository {
    private val mapper = CharacterMapper()
    override suspend fun getCharacters(): List<CharacterModel> {
        return mapper.mapListDtoToListModel(RetrofitInstance.searchCharactersApi.getCharacters())
    }

    override suspend fun getCharacterById(id: Int): CharacterModel {
        return mapper.mapDtoToModel(RetrofitInstance.searchCharactersApi.getCharacterByIdPath(id))
    }
}

