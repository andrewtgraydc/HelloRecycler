package com.example.hellorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*> // generic
    private lateinit var viewManager: RecyclerView.LayoutManager

    // test commit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = mutableListOf("Skittles", "Starburst", "Sour Patch Kids")

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataset)

        // view or data binding
        // apply is scoping function (kotlin)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // improve performance
            //setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter
            adapter = viewAdapter

        }
    }
}
