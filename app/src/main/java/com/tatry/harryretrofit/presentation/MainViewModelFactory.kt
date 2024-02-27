package com.tatry.harryretrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase
import com.tatry.harryretrofit.domain.usecase.GetCharacterUseCase

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val repo = CharacterRepositoryImpl
            val useCase1 = GetCharacterUseCase(repo)
            val useCase2 = GetCharacterListUseCase(repo)
            return MainViewModel(repo, useCase1, useCase2) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}