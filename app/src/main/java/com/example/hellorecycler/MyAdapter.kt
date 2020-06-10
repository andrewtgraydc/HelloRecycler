package com.example.hellorecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.candy_text_layout.view.*

class MyAdapter(private val myCandies: List<CandyData>, private val candyClickHandler: (CandyData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // the primary constructor creates the property no additional declaration needed

    // provide a reference to the views for each data item
    // provide access to all the views for a data item in a view holder.
    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(candy: CandyData, candyClickHandler: (CandyData) -> Unit) { // typically pass in object and interface
            val candyTextView = view.findViewById<TextView>(R.id.candy_text_view).apply {
                setText(candy.candyName)
            }

            // after the user presses the view, this code is executed
            view.setOnClickListener { candyClickHandler(candy) }
        }

        val candyImage: ImageView = view.findViewById<ImageView>(R.id.imageView)
    }

    /// these 3 are required members of Adapter

    // tie data to view on screen
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? MyViewHolder)?.bindData(myCandies[position], candyClickHandler)
    }

    // Create new views (called by layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // this will be view group, result of inflation
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.candy_text_layout, parent, false)

        return MyViewHolder(layout)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return myCandies.size
    }
}