package com.example.apiprojekat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.apiprojekat.adapter.GameAdapter
import com.example.apiprojekat.databinding.ActivityGameDetailsBinding
import com.example.apiprojekat.network.APIResponse
import com.example.apiprojekat.Game
import com.example.apiprojekat.db.Db
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

        val gameDao = Db.getInstance(application).dbDao
        val gameId = intent.getIntExtra("id",0)
        val sacuvaj = binding.sacuvaj

        val shareBtn = binding.share
        shareBtn.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Igra "+binding.name.text.toString() +
                        " je izbacena " +binding.released.text.toString() +
                        "i prosjecno vrijeme igranja je " + binding.playtime.text.toString() +" sati.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


        if (gameDao.getGameById(gameId) == null) {
            binding.sacuvaj.text = "Sacuvaj igru"
            sacuvaj.setOnClickListener {
                gameDao.insert(
                    Game(
                        gameId,
                        binding.name.text.toString(),
                        binding.released.text.toString(),
                        binding.gameRating.text.toString(),
                        "",
                        binding.playtime.text.toString().toInt()
                    )
                )
            }
        }
        else {

                sacuvaj.text = "Obrisi"
            binding.sacuvaj.setOnClickListener { gameDao.deleteById(gameId) }

        }


        GameAPI.retrofitService.getGameDetails(gameId
        ).enqueue(
            object: Callback<Game> {
                override fun onResponse(
                    call: Call<Game>,
                    response: Response<Game>
                ) {
                    val gameData = response.body()
                    if (gameData != null) {
                        binding.name.text = gameData.name
                        binding.released.text = gameData.released
                        binding.gameRating.text = gameData.rating
                        binding.playtime.text = gameData.playtime.toString() + "h"
                        Glide.with(view).load(gameData.image).into(binding.gamePhoto)
                        Log.d(gameData.image, "nesto")
                    }

                }

                override fun onFailure(call: Call<Game?>?, t: Throwable?) {
                    val gameData = gameDao.getGameById(gameId)
                    if (gameData != null) {
                        binding.name.text = gameData.name
                        binding.released.text = gameData.released
                        binding.gameRating.text = gameData.rating
                        binding.playtime.text = gameData.playtime.toString()
                        // nema slike bez interneta
                    }
                }
            })
    }
}