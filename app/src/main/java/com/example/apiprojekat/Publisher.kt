package com.example.apiprojekat

import com.squareup.moshi.Json

data class Publisher(
    @Json(name = "id")
    val id : Int,

    @Json(name= "name")
    val name : String,

    @Json(name= "games_count")
    val gamesCount : Int?,

    @Json(name= "image_background")
    val imageBackground : String?,

    @Json(name="description")
    val description : String?

)
