package com.tatry.harryretrofit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tatry.harryretrofit.App

class DbViewModelFactory: ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(DbViewModel::class.java)) {
//            return DbViewModel(App().db.characterDao()) as T
//        }
//        throw IllegalArgumentException("Unknown class name")
//    }
}