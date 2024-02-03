package com.tatry.harryretrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

// связующая таблица (нет прямых ссылок на id), грубое соединение
// декартово произведение
// на основе этой таблицы персонажей соединяем с метлами
@Entity(tableName = "character_broom",
    primaryKeys = [])
data class CharacterBroom(
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "broom_id")
    val broomId: Int
)
