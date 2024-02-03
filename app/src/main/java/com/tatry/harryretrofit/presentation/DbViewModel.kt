package com.tatry.harryretrofit.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tatry.harryretrofit.App
import com.tatry.harryretrofit.data.local.dao.CharacterDao
import com.tatry.harryretrofit.data.local.entity.CharacterDbModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DbViewModel
//    (private val appDao: CharacterDao)
    : ViewModel() {

//    // на этот сигнал подписываемся во фрагменте
//    val allCharacters = appDao.getAllCharacters()
////        настройка flow
//        .stateIn(
//            scope = viewModelScope,
////            как данные обновились перерисовать ui
//            started = SharingStarted.WhileSubscribed(5000L),
//            initialValue = emptyList()
//        )


    private lateinit var characterDao: CharacterDao

    //    для List без Flow
    private var _characters = MutableStateFlow<List<CharacterDbModel>>(mutableListOf())
    val characters = _characters

//    val characters = characterDao.getAllCharacters()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(500L),
//            initialValue = mutableListOf()
//        )

    init {

    }

    fun onBtnAdd() {
        var size = characters.value.size
//        var size = _characters.value.size
        size++
        val newCharacterDb = CharacterDbModel(
            id = size,
            name = "Potter $size"
        )

        viewModelScope.launch {
            characterDao.insertCharacter(newCharacterDb)
        }
        updateTextView()
    }

    fun initDao(application: Application?) {
        characterDao = (application as App).db.characterDao()
        updateTextView()
    }

    fun onBtnDelete() {
        viewModelScope.launch {
            characters.value.lastOrNull()?.let { characterDao.deleteCharacter(it) }
//            _characters.value.lastOrNull()?.let { characterDao.deleteCharacter(it) }
        }
        updateTextView()
    }

    fun onBtnUpdate() {
        viewModelScope.launch {
//            _characters.value.lastOrNull()?.let {
            characters.value.lastOrNull()?.let {
                val newCharacter = CharacterDbModel(it.id, "Severus")
//                characterDao.updateCharacter(newCharacter)
                characterDao.updateCharacter(it.copy(name = "Severus"))
            }
        }
        updateTextView()
    }

    private fun updateTextView() {
        viewModelScope.launch {
            _characters.value = characterDao.getAllCharacters()
        }
    }
}