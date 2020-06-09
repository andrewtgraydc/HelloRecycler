package com.example.hellorecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.candy_text_layout.view.*

// private val myDataset: Array<String>?? i get it now that the primary constructor creates the property
// no additional declaration needed

class MyAdapter(private val myCandies: List<CandyData>, val clickListener: (CandyData)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() { // rarely need type

    // provide a reference to the views for each data item
    // provide access to all the views for a data item in a view holder.
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun setText(label: String) {
            view.findViewById<TextView>(R.id.candy_text_view).apply {
                text = label
            }
        }

        // replace with:
        fun bindData(candy: CandyData, clickListener: (CandyData)): Unit {

            view.candy_text_view.text = candy.candyName

            view.setOnClickListener { clickListener(candy) }
        }


        //val candyImage: ImageView = findViewById<ImageView>(R.id.imageView)
    }

    /// these 3 are required members of Adapter

    // tie data to view on screen
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // cast the generic viewholder
        //(holder as? MyViewHolder)?.setText(myDataset[position])

        // replace with:
        (holder as? MyViewHolder)?.bindData(myCandies[position], clickListener)
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

    // Previously, a ListView’s or GridView’s onItemClickListener managed item clicks. A RecyclerView doesn’t provide methods like this because its focus is ensuring the position and management of the items within.
}