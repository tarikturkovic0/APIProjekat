package com.example.apiprojekat.network

import android.provider.Contacts
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL =
        "https://api.rawg.io/api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

     val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface GamesApiService {
        @GET("games?key=39ec2789fdf64c35a9fff0dad7797613&page_size=30")
        fun getGames():
                Call<APIResponse>
        @GET("games/{id}?key=39ec2789fdf64c35a9fff0dad7797613")
        fun getGameDetails(@Path("id")  id : Int)  : Call<Game>


    }
    object GameAPI {
    val retrofitService : GamesApiService by lazy {
        retrofit.create(GamesApiService::class.java) }
    }



data class APIResponse(
    @Json(name = "count")
    val count: Int,
    @Json(name= "results")
    val results : List<Game>

)

data class Game(
    @Json(name = "id")
    val id : Int,

    @Json(name= "name")
    val name : String,

    @Json(name= "released")
    val released : String,

    @Json(name= "rating")
    val rating : String,

    @Json(name="background_image")
    val image : String,

    @Json(name="playtime")
    val playtime : Int



)

