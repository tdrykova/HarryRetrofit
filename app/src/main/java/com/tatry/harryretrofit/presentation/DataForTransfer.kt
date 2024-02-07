package com.tatry.harryretrofit.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataForTransfer(
    val field1: String,
    val field2: Int
):Parcelable