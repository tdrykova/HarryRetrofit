package com.tatry.harryretrofit.data.network.mapper

import com.google.gson.Gson
import com.tatry.harryretrofit.data.network.dto.CharacterDto
import com.tatry.harryretrofit.domain.model.CharacterModel

class CharacterMapper {

    fun mapDtoToModel(characterDto: CharacterDto) = CharacterModel(
        id = characterDto.id,
        name = characterDto.name,
        hogwartsHouse = characterDto.hogwartsHouse,
        imageUrl = characterDto.imageUrl
    )
//    fun mapDtoToModel(characterDto: CharacterDto): CharacterModel = Gson().fromJson(characterDto.toString(),
//    CharacterModel::class.java)

    fun mapListDtoToListModel(dtoList: List<CharacterDto>): List<CharacterModel> {
        val resList = mutableListOf<CharacterModel>()
        dtoList.forEach { resList.add(mapDtoToModel(it)) }
        return resList
    }

//    fun mapListDtoToListModel(dtoList: List<CharacterDto>): List<CharacterModel> {
//        val resList = mutableListOf<CharacterModel>()
//        dtoList.forEach { resList.add(mapDtoToModel(it)) }
//        return resList
//    }
}