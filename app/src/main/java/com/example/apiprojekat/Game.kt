package com.example.apiprojekat

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "games")
data class Game(
    @PrimaryKey()
    @Json(name = "id")
    val id : Int,

    @ColumnInfo(name = "name")
    @Json(name= "name")
    val name : String,

    @ColumnInfo(name = "released")
    @Json(name= "released")
    val released : String,

    @ColumnInfo(name = "rating")
    @Json(name= "rating")
    val rating : String,

    @Json(name="background_image")
    val image : String,

    @ColumnInfo(name = "playtime")
    @Json(name="playtime")
    val playtime : Int

)

