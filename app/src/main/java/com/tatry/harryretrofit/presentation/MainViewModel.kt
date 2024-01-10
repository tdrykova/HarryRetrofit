package com.tatry.harryretrofit.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase
import com.tatry.harryretrofit.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainFragment555"

class MainViewModel(
    private val repo: CharacterRepositoryImpl,
    private val getCharacterUseCase: GetCharacterUseCase,
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {


    private var _character = MutableStateFlow<CharacterModel>(CharacterModel())
    var character = _character.asStateFlow()

    private var _characterList = MutableStateFlow<List<CharacterModel>>(mutableListOf())
    var characterList = _characterList.asStateFlow()

    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
    var state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ProgressState.Loading
            try {
                _character.value = getCharacterUseCase.getCharacter()
                _characterList.value = getCharacterListUseCase.getCharacterList()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}", t)
            }
            _state.value = ProgressState.Success
        }
    }

    fun randomCharacter() {
//        _character.value = _characterList.value.random()
        viewModelScope.launch {
            _state.value = ProgressState.Loading
            try {
                val listSize = _characterList.value.size
                _character.value = getCharacterUseCase.getCharacter((1..listSize).random())
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}", t)
            }
            _state.value = ProgressState.Success
        }
    }
}