package com.tatry.harryretrofit.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TAG = "CharacterListViewModel555"

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase // inject зависимости
) : ViewModel() {
//    private val repository = CharacterRepositoryImpl
//    val getCharacterListUseCase = GetCharacterListUseCase(repository)

    val onlySlytherin = MutableStateFlow(false)

    // у List нет метода remove в отличие от MutableList
    private var _characterList = MutableStateFlow<MutableList<CharacterModel>>(mutableListOf())
    val characterList: StateFlow<List<CharacterModel>> = combine(
        _characterList,
        onlySlytherin
    ) { characters, onlySlytherin ->
        if (onlySlytherin) {
            characters.filter { it.hogwartsHouse == "Slytherin" }
        } else {
            characters
        }

    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = _characterList.value
    )

//    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
//    val state = _state.asStateFlow()

    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                _isLoading.value = true
                getCharacterListUseCase.getCharacterList().toMutableList()
            }.fold(
                onSuccess = {_characterList.value = it},
                onFailure = {Log.e(TAG, "${it.message}: ", it)}
            )
            _isLoading.value = false
        }
    }


    fun deleteCharacterAfterSwipe(item: CharacterModel) {
        _characterList.value.remove(item)
        // изменение идет в поток
        // поток подключается в ListFragment
    }

}