package com.example.apiprojekat.adapter



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiprojekat.GameDetailsActivity
import com.example.apiprojekat.R
import com.example.apiprojekat.network.Game


class GameAdapter(
    private val context: Context,
    private var dataset: List<Game>,
    private val OriginalDataset : List<Game> = dataset
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class GameViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val game_title: TextView = view.findViewById(R.id.game_title)
        val rating: TextView = view.findViewById(R.id.rating)
        val detaljiButton : Button = view.findViewById(R.id.detalji)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.game, parent, false)

        return GameViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = dataset[position]
        holder.game_title.text = game.name
        holder.rating.text = game.rating
        holder.detaljiButton.setOnClickListener{
            context.startActivity(Intent(context, GameDetailsActivity::class.java).putExtra("id",game.id))


        }

    }
    fun filterData(flag : Int)  {

        if (flag == 1) {
        val filteredList = mutableListOf<Game>()
        val itr = OriginalDataset.iterator()
        while (itr.hasNext())
        {
            val curr = itr.next()

            if (curr.rating.toFloat() > 4 ) {
                filteredList.add(curr)
            }
        }
        dataset =  filteredList.toList()
        }
        else {
            dataset = OriginalDataset
        }
        notifyDataSetChanged()

    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}