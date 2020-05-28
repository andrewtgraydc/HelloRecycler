package com.example.hellorecycler

// private val myDataset: Array<String>??

class MyAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // provide a reference to the views for each data item
    // provide access to all the views for a data item in a view holder.
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


    // these 3 are required members of Adapter

    // Create new views (called by layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false) as TextView // need text view xml?
        // set the view's size, etc

        return MyViewHolder(textView)
    }

    // tie data to view on screen
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = myDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size

}