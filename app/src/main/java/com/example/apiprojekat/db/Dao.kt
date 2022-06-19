package com.example.apiprojekat.db


import com.example.apiprojekat.Game


import android.graphics.Color
import androidx.room.*

@Dao
interface GameDao {

    @Query("SELECT * FROM games")
    fun getAll(): List<Game>

    @Query("SELECT * FROM GAMES WHERE ID = :gameId")
    fun getGameById(gameId : Int) : Game?

    @Insert
    fun insert(vararg game: Game)

    @Query("DELETE FROM GAMES WHERE ID = :gameId")
    fun deleteById(gameId: Int )
}