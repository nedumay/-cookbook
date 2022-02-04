package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.adapters.RecyclerAdapter
import com.example.cookbook.adapters.onRecyclerClickListener
import com.example.cookbook.data.DataItem
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar


class MainMenuActivity : AppCompatActivity() {

    private val dataItem: ArrayList<DataItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        setInitialSavedState()

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val recClickListener = object: onRecyclerClickListener{
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> { Toast.makeText(applicationContext,"test1", Toast.LENGTH_SHORT).show() }
                }
            }
        }
        val adapter = RecyclerAdapter(this, dataItem, recClickListener)
        recyclerView.adapter = adapter

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        }
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    // Handle favorite icon press
                    true
                }
                R.id.search -> {
                    // Handle search icon press
                    true
                }
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }

    }


    private fun setInitialSavedState() {
        dataItem.add(DataItem(R.string.сold_appetizern,R.drawable.ice_appetizer))
        dataItem.add(DataItem(R.string.hot_appetizern,R.drawable.hot_appetizer))
        dataItem.add(DataItem(R.string.second_dishes,R.drawable.seconds_dishes))
        dataItem.add(DataItem(R.string.soup,R.drawable.soups))
        dataItem.add(DataItem(R.string.salads,R.drawable.salads))
        dataItem.add(DataItem(R.string.porridge,R.drawable.porridges))
        dataItem.add(DataItem(R.string.dessert,R.drawable.desserts))
        dataItem.add(DataItem(R.string.sauce,R.drawable.sauce))
        dataItem.add(DataItem(R.string.drinks,R.drawable.drinks))
    }

}