package com.example.apiprojekat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn1 = view.findViewById<Button>(R.id.button)
        btn1.setOnClickListener{
            val intent = Intent(activity, GameListActivity::class.java)

            startActivity(intent)
        }
        val btn2 = view.findViewById<Button>(R.id.button2)
        btn2.setOnClickListener{
            val intent = Intent(activity, PublishersListActivity::class.java)

            startActivity(intent)
        }

        val btn4 =  view.findViewById<Button>(R.id.button4)

        btn4.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gridPictures)

        }
    }

}