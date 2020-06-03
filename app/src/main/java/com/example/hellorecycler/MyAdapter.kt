package com.example.hellorecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// private val myDataset: Array<String>??

class MyAdapter(private val myDataset: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() { // rarely need type


    // provide a reference to the views for each data item
    // provide access to all the views for a data item in a view holder.
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun setText(label: String) {
            view.findViewById<TextView>(R.id.candy_text_view).apply {
                text = label
            }

        }
    }
// this will be view group, result of inflation

    // these 3 are required members of Adapter

    // Create new views (called by layout manager)


    // tie data to view on screen
    // cast the generic viewholder


    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount(): Int {
//
//        return myDataset.size
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? MyViewHolder)?.setText(myDataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.candy_text_layout, parent, false)

        // set the view's size, etc

        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return 3
    }

}