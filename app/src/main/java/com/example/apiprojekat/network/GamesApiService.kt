package com.example.apiprojekat.network

import android.provider.Contacts
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apiprojekat.Game
import com.example.apiprojekat.Publisher
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
        fun getGames(): Call<APIResponse>

        @GET("games/{id}?key=39ec2789fdf64c35a9fff0dad7797613")
        fun getGameDetails(@Path("id")  id : Int)  : Call<Game>

        @GET("publishers?key=39ec2789fdf64c35a9fff0dad7797613")
        fun getPublishers() : Call<APIResponse2>


        @GET("publishers/{id}?key=39ec2789fdf64c35a9fff0dad7797613")
        fun getPublisherDetails(@Path("id")  id : Int)  : Call<Publisher>

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

data class APIResponse2(
    @Json(name = "count")
    val count: Int,
    @Json(name= "results")
    val results : List<Publisher>

)

