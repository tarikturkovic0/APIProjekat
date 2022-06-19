package com.example.apiprojekat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.example.apiprojekat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            val intent = Intent(this, GameListActivity::class.java)

            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, PublishersListActivity::class.java)

            startActivity(intent)
        }
    }
}