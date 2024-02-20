package com.tatry.harryretrofit.presentation

sealed class ProgressState {
    object Loading : ProgressState()
    object Success : ProgressState()
}