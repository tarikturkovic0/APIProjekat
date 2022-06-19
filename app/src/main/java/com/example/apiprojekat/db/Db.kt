package com.example.apiprojekat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.apiprojekat.Game
import com.example.apiprojekat.db.GameDao

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {

    abstract val dbDao: GameDao

    companion object {

        @Volatile
        private var INSTANCE: Db? = null

        fun getInstance(context: Context): Db {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Db::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}