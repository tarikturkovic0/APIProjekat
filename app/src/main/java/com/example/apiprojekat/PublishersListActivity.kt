package com.example.apiprojekat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiprojekat.adapter.GameAdapter
import com.example.apiprojekat.adapter.PublisherAdapter
import com.example.apiprojekat.databinding.ActivityGameListBinding
import com.example.apiprojekat.databinding.ActivityPublishersListBinding
import com.example.apiprojekat.db.Db
import com.example.apiprojekat.network.APIResponse
import com.example.apiprojekat.network.APIResponse2
import com.example.apiprojekat.network.GameAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PublishersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPublishersListBinding
    private lateinit var adapter : PublisherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishersListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        val recyclerView = binding.rv2
        adapter = PublisherAdapter(this@PublishersListActivity, listOf<Publisher>())
        recyclerView.adapter = adapter
        binding.noconnection.visibility = View.GONE

        GameAPI.retrofitService.getPublishers().enqueue(
            object: Callback<APIResponse2> {
                override fun onResponse(
                    call: Call<APIResponse2>,
                    response: Response<APIResponse2>
                ) {
                    val publisherData = response.body()?.results ?: listOf()
                    adapter = PublisherAdapter(this@PublishersListActivity, publisherData)
                    recyclerView.adapter = adapter

                }

                override fun onFailure(call: Call<APIResponse2?>?, t: Throwable?) {
                    binding.noconnection.visibility = View.VISIBLE
                    binding.rv2.visibility = View.INVISIBLE
                    binding.lyt.visibility = View.INVISIBLE


                }
            })



    }
}