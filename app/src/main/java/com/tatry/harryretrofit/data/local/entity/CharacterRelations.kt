package com.tatry.harryretrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation


data class CharacterRelations(
    @Embedded
    val characterDd: CharacterDbModel,

    // связь 1 к 1 (1 персонажу соответствует 1 палочка)
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val wandDb: WandDbModel?,

    // связь 1 ко многим (1 персонажу соответствует несколько книг)
    @Relation(
        entity = BookDb::class,
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val books: List<BookDb>
)