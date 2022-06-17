package com.example.apiprojekat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.apiprojekat.adapter.GameAdapter
import com.example.apiprojekat.databinding.ActivityGameDetailsBinding
import com.example.apiprojekat.network.APIResponse
import com.example.apiprojekat.network.Game
import com.example.apiprojekat.network.GameAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GameDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val gameId = intent.getIntExtra("id",0)
        GameAPI.retrofitService.getGameDetails(gameId
        ).enqueue(
            object: Callback<Game> {
                override fun onResponse(
                    call: Call<Game>,
                    response: Response<Game>
                ) {
                    Log.d("aaa",response.body().toString())
                    val gameData = response.body()
                    if (gameData != null) {
                        binding.name.text = gameData.name
                        binding.released.text = gameData.released
                        binding.gameRating.text = gameData.rating
                        binding.playtime.text = gameData.playtime.toString()
                        Glide.with(view).load(gameData.image).into(binding.gamePhoto)
                    }

                }

                override fun onFailure(call: Call<Game?>?, t: Throwable?) {
                    if (t != null) {
                        Log.d("aaa",t.message.toString()+"haha")
                    }

                }
            })
    }
}