package com.tatry.harryretrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterDbModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
//    @ColumnInfo(name="hogwarts_house")
//    val hogwartsHouse: String,
//    @ColumnInfo(name="image_url")
//    val imageUrl: String

//    @Embedded(prefix = "wand_")
//    val wand: WandDbModel?


)