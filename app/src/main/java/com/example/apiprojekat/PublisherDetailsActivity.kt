package com.example.apiprojekat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.core.text.HtmlCompat


import com.bumptech.glide.Glide
import com.example.apiprojekat.databinding.ActivityGameDetailsBinding
import com.example.apiprojekat.databinding.ActivityPublisherDetailsBinding
import com.example.apiprojekat.db.Db
import com.example.apiprojekat.network.GameAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PublisherDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublisherDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublisherDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val publisherId = intent.getIntExtra("id",0)



        GameAPI.retrofitService.getPublisherDetails(publisherId
        ).enqueue(
            object: Callback<Publisher> {
                override fun onResponse(
                    call: Call<Publisher>,
                    response: Response<Publisher>
                ) {
                    val publisherData = response.body()
                    if (publisherData != null) {
                        binding.publisherName.text = publisherData.name
                        binding.gamesCount.text = "Broj objavljenih igara: " + publisherData.gamesCount.toString()
                        binding.publisherDesc.text = HtmlCompat.fromHtml(publisherData.description!!,0)
                        Glide.with(view).load(publisherData.imageBackground).into(binding.publisherPhoto)
                    }

                }

                override fun onFailure(call: Call<Publisher?>?, t: Throwable?) {

                }
            })
    }
}