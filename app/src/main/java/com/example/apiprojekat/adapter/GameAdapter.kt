package com.example.apiprojekat.adapter



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiprojekat.R



class GameAdapter(
    private val context: Context,
    private val dataset: List<com.example.apiprojekat.network.Game>
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
        /*holder.detaljiButton.setOnClickListener{

        }*/
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}