package com.example.apiprojekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiprojekat.adapter.GridAdapter

class GridPictures : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_grid_pictures, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        var manager = GridLayoutManager(this.context, 2)
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = GridAdapter(vratiSlike(),view.context)
        recyclerView.adapter = adapter
        recyclerView.apply {
            LinearLayoutManager(view.context)
        }
    }
    private fun vratiSlike() : ArrayList<String>{
        var list : ArrayList<String> = ArrayList<String>()
        val el1 : String = "https://media.rawg.io/media/games/562/562553814dd54e001a541e4ee83a591c.jpg"
        list.add(el1)
        var el2 : String = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg"
        list.add(el2)
        var el3 : String = "https://media.rawg.io/media/games/7fa/7fa0b586293c5861ee32490e953a4996.jpg"
        list.add(el3)
        var el4 : String = "https://media.rawg.io/media/games/b8c/b8c243eaa0fbac8115e0cdccac3f91dc.jpg"
        list.add(el4)
        var el5 : String = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg"
        list.add(el5)
        var el6 : String = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg"
        list.add(el6)
        var el7 : String = "https://media.rawg.io/media/games/fc1/fc1307a2774506b5bd65d7e8424664a7.jpg"
        list.add(el7)
        var el8 : String = "https://media.rawg.io/media/games/7cf/7cfc9220b401b7a300e409e539c9afd5.jpg"
        list.add(el8)
        var el9 : String = "https://media.rawg.io/media/games/588/588c6bdff3d4baf66ec36b1c05b793bf.jpg"
        list.add(el9)
        var el10 : String = "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be59.jpg"
        list.add(el10)
        var el11 : String = "https://media.rawg.io/media/games/588/588c6bdff3d4baf66ec36b1c05b793bf.jpg"
        list.add(el11)
        var el12 : String = "https://media.rawg.io/media/games/c4b/c4b0cab189e73432de3a250d8cf1c84e.jpg"
        list.add(el12)
        return list
    }
}