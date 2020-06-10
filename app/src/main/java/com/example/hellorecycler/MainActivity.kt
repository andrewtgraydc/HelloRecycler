package com.example.hellorecycler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// It's a good practice to define keys for intent extras with your app's package name as a prefix.
// This ensures that the keys are unique, in case your app interacts with other apps.
const val CANDY_NAME = "com.example.hellorecycler.candyName"

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*> // generic
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create dataset. TODO: all in separate function
        val myCandyData = ArrayList<CandyData>()
        myCandyData.add(CandyData(1, "Skittles"))
        myCandyData.add(CandyData(2, "Starburst"))
        myCandyData.add(CandyData(3, "Sour Patch Kids"))

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myCandyData, candyFun)

        // apply is scoping function (kotlin)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter
            adapter = viewAdapter
        }
    }

    /// handle onClick by showing detail activity
    private val candyFun = { candyItem: CandyData -> // separates parameters and body
        Log.i("candy1", "candy clicked")

        // launch second, detail activity, passing candy string
        val showDetailIntent = Intent(this, CandyDetailActivity::class.java).apply {
            putExtra(CANDY_NAME, candyItem.candyName)
        }
        startActivity(showDetailIntent)
    }
}
