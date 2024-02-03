package com.tatry.harryretrofit.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "broom")
data class BroomDb (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "broom_id")
    val broomId: Int,
    @ColumnInfo(name = "name")
    val name: String
)