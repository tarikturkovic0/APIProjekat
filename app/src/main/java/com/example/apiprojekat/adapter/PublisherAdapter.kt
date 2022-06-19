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

import com.example.apiprojekat.Publisher
import com.example.apiprojekat.PublisherDetailsActivity
import com.example.apiprojekat.R

class PublisherAdapter(
    private val context: Context,
    private var dataset: List<Publisher>
) : RecyclerView.Adapter<PublisherAdapter.PublisherViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class PublisherViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val publisher_naziv: TextView = view.findViewById(R.id.ime_publishera)
        val detaljiButton : Button = view.findViewById(R.id.detalji2)

    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherAdapter.PublisherViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.publisher, parent, false)

        return PublisherAdapter.PublisherViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: PublisherAdapter.PublisherViewHolder, position: Int) {
        val publisher = dataset[position]
        holder.publisher_naziv.text = publisher.name
        holder.detaljiButton.setOnClickListener{
            context.startActivity(Intent(context, PublisherDetailsActivity::class.java).putExtra("id",publisher.id))


        }

    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}