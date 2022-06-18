package com.example.apiprojekat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apiprojekat.adapter.GameAdapter
import com.example.apiprojekat.databinding.ActivityGameListBinding
import com.example.apiprojekat.network.APIResponse
import com.example.apiprojekat.Game
import com.example.apiprojekat.db.Db
import com.example.apiprojekat.network.GameAPI
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.sql.DataSource

class GameListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameListBinding
    private lateinit var adapter : GameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding = ActivityGameListBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)


        val switch = binding.switch2


        val recyclerView = binding.rv
        adapter = GameAdapter(this@GameListActivity, mutableListOf<Game>())
        recyclerView.adapter = adapter
        GameAPI.retrofitService.getGames().enqueue(
            object: Callback<APIResponse> {
                override fun onResponse(
                    call: Call<APIResponse>,
                    response: Response<APIResponse>
                ) {
                   val gameData = response.body()?.results ?: listOf()
                    adapter = GameAdapter(this@GameListActivity, gameData)
                    recyclerView.adapter = adapter
                    // Use this setting to improve performance if you know that changes
                    // in content do not change the layout size of the RecyclerView
                    recyclerView.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<APIResponse?>?, t: Throwable?) {

                    val gameDao = Db.getInstance(application).dbDao
                    val savedGames = gameDao.getAll()
                    adapter = GameAdapter(this@GameListActivity,savedGames)
                    recyclerView.adapter = adapter
                    recyclerView.setHasFixedSize(true)

                }
            })
            switch.setOnCheckedChangeListener { compoundButton, b ->
                if (switch.isChecked) {
                   adapter.filterData(1)
                }
                else {
                    adapter.filterData(0)
                }
            }


    }
}