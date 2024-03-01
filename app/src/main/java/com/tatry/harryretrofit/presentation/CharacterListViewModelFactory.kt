package com.tatry.harryretrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase

class CharacterListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)) {
            return CharacterListViewModel(GetCharacterListUseCase(CharacterRepositoryImpl)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}