package com.tatry.harryretrofit.presentation

import androidx.lifecycle.ViewModel
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase

class CharacterListViewModel : ViewModel() {
    private val repository = CharacterRepositoryImpl
    val getCharacterListUseCase = GetCharacterListUseCase(repository)


}