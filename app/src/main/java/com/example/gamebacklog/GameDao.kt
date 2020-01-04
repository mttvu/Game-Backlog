package com.example.gamebacklog

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    fun insertGame(reminder: Game)

    @Delete
    suspend fun deleteGame(reminder: Game)
}