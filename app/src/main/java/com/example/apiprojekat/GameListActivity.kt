package com.example.apiprojekat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apiprojekat.adapter.GameAdapter
import com.example.apiprojekat.databinding.ActivityGameListBinding
import com.example.apiprojekat.network.APIResponse
import com.example.apiprojekat.network.Game
import com.example.apiprojekat.network.GameAPI
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.sql.DataSource

class GameListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityGameListBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)


        val recyclerView = binding.rv

        GameAPI.retrofitService.getGames().enqueue(
            object: Callback<APIResponse> {
                override fun onResponse(
                    call: Call<APIResponse>,
                    response: Response<APIResponse>
                ) {
                   val gameData = response.body()?.results ?: listOf()
                    recyclerView.adapter = GameAdapter(this@GameListActivity, gameData)
                    // Use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    recyclerView.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<APIResponse?>?, t: Throwable?) {
                    if (t != null) {
                        Log.d("odgovor",t.message.toString())
                    }

                }
            })



    }
}