package com.tatry.harryretrofit.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatry.harryretrofit.data.network.CharacterRepositoryImpl
import com.tatry.harryretrofit.domain.model.CharacterModel
import com.tatry.harryretrofit.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "CharacterListViewModel555"
class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase // inject зависимости
) : ViewModel() {
//    private val repository = CharacterRepositoryImpl
//    val getCharacterListUseCase = GetCharacterListUseCase(repository)

    // у List нет метода remove в отличие от MutableList
    private var _characterList = MutableStateFlow<MutableList<CharacterModel>>(mutableListOf())
    val characterList = _characterList.asStateFlow()

//    private var _state = MutableStateFlow<ProgressState>(ProgressState.Success)
//    val state = _state.asStateFlow()

    private var _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _characterList.value = getCharacterListUseCase.getCharacterList().toMutableList()
            } catch (t: Throwable) {
                Log.e(TAG, "${t.message}: ", t)
            }
            _isLoading.value = false
        }
    }


    fun deleteCharacterAfterSwipe(item: CharacterModel) {
        _characterList.value.remove(item)
        // изменение идет в поток
            // поток подключается в ListFragment
    }

}