package com.tatry.harryretrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation


data class CharacterWithBooks(
    @Embedded
    val characterDbModel: CharacterDbModel,
    @Relation(
        entity = BookDb::class,
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val books: List<BookDb>
)
