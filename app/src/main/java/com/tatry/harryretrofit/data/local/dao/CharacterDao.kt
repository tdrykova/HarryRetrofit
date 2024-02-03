package com.tatry.harryretrofit.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.tatry.harryretrofit.data.local.entity.CharacterDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Transaction // если таблица состоит из нескольких Entity - Transaction
    // выполняется полностью / не выполняется = suspend fun getAllCharacters(): List<CharacterWithWandDb>
    @Query("SELECT * FROM character")
//    @Query("SELECT * FROM character WHERE id=:id")
//    suspend fun getAllCharacters(id: Int): List<CharacterDbModel>

//    fun getAllCharacters(): Flow<List<CharacterDbModel>>
    suspend fun getAllCharacters(): List<CharacterDbModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterDbModel: CharacterDbModel)

    @Update
    suspend fun updateCharacter(characterDbModel: CharacterDbModel)

    @Delete(entity = CharacterDbModel::class)
    suspend fun deleteCharacter(characterDbModel: CharacterDbModel)
}