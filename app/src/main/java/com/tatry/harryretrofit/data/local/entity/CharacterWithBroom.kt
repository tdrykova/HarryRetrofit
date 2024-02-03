package com.tatry.harryretrofit.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity()
data class CharacterWithBroom (

    @Embedded
    val characterDbModel: CharacterDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "broom_id",
        associateBy = Junction(
            CharacterBroom::class, // связующая таблица
            parentColumn = "character_id",
            entityColumn = "broom_id"
        )
    )
    val brooms: List<BroomDb>
)