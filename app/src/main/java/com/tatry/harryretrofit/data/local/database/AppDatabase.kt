package com.tatry.harryretrofit.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tatry.harryretrofit.data.local.dao.CharacterDao
import com.tatry.harryretrofit.data.local.entity.BookDb
import com.tatry.harryretrofit.data.local.entity.CharacterDbModel
import com.tatry.harryretrofit.data.local.entity.WandDbModel

@Database(entities = [CharacterDbModel::class, WandDbModel::class, BookDb::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    // реализовать интерфейс CharacterDao или
    // указать abstract (тогда и сам класс должен быть abstract)
    abstract fun characterDao() : CharacterDao

}