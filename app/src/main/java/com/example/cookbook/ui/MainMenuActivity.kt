package com.example.cookbook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.R
import com.example.cookbook.adapters.RecyclerAdapter
import com.example.cookbook.adapters.onRecyclerClickListener
import com.example.cookbook.data.DataInitItem
import com.example.cookbook.data.DataItem
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class MainMenuActivity : AppCompatActivity() {

    //private val dataItemCat: ArrayList<DataItem> = ArrayList()
    //private val dataItemNat: ArrayList<DataItem> = ArrayList()
    private val dataItem = DataInitItem()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        dataItem.setInitialSavedStateCat()
        dataItem.setInitialSavedStateNat()

        val recyclerViewCat:RecyclerView = findViewById(R.id.recyclerView)
        val recClickListenerCat = object: onRecyclerClickListener{
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val intent = Intent(this@MainMenuActivity, ListRecipes::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterCat = RecyclerAdapter(this, dataItem.dataItemCat, recClickListenerCat)
        recyclerViewCat.adapter = adapterCat

        val recyclerViewNat: RecyclerView = findViewById(R.id.recyclerView2)
        val recClickListenerNat = object: onRecyclerClickListener{
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> { Toast.makeText(applicationContext,"test1", Toast.LENGTH_SHORT).show() }
                }
            }
        }
        val adapterNat = RecyclerAdapter(this, dataItem.dataItemNat, recClickListenerNat)
        recyclerViewNat.adapter = adapterNat

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)

        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.close()
            true
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.more -> {
                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }

        }

    }


    /*private fun setInitialSavedStateCat() {
        dataItemCat.add(DataItem(R.string.сold_appetizern,R.drawable.ice_appetizer))
        dataItemCat.add(DataItem(R.string.hot_appetizern,R.drawable.hot_appetizer))
        dataItemCat.add(DataItem(R.string.second_dishes,R.drawable.seconds_dishes))
        dataItemCat.add(DataItem(R.string.soup,R.drawable.soups))
        dataItemCat.add(DataItem(R.string.salads,R.drawable.salads))
        dataItemCat.add(DataItem(R.string.porridge,R.drawable.porridges))
        dataItemCat.add(DataItem(R.string.dessert,R.drawable.desserts))
        dataItemCat.add(DataItem(R.string.sauce,R.drawable.sauce))
        dataItemCat.add(DataItem(R.string.drinks,R.drawable.drinks))
    }

    private fun setInitialSavedStateNat() {
        dataItemNat.add(DataItem(R.string.russian_kitchen,R.drawable.russia))
        dataItemNat.add(DataItem(R.string.asia_kitchen,R.drawable.asia))
        dataItemNat.add(DataItem(R.string.europe_kitchen,R.drawable.europe))
        dataItemNat.add(DataItem(R.string.kavkaz_kitchen,R.drawable.kavkaz))
        dataItemNat.add(DataItem(R.string.vostok_kitchen,R.drawable.vostok))
        dataItemNat.add(DataItem(R.string.mexico_kitchen,R.drawable.mexico))
    }*/

}