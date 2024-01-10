package com.tatry.harryretrofit.data.network.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// dto for Moshi
@JsonClass(generateAdapter = true)
data class CharacterDto (
    @Json(name="id")
    val id: Int,
    @Json(name="character")
    val name: String,
    @Json(name="hogwartsHouse")
    val hogwartsHouse: String,
    @Json(name="image")
    val imageUrl: String
)

//// dto for Gson
//data class CharacterDto (
//    val id: Int,
//    @SerializedName("character")
//    val name: String,
//    val hogwartsHouse: String,
//    @SerializedName("image")
//    val imageUrl: String
//)