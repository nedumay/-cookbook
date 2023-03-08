package com.example.cookbook.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookbook.presentation.adapters.RecyclerAdapter
import com.example.cookbook.presentation.adapters.onRecyclerClickListener
import com.example.cookbook.data.DataInitItem
import com.example.cookbook.data.DataItem
import com.example.cookbook.databinding.FragmentMainBinding
import com.example.cookbook.presentation.ui.ListRecipes

class MainFragment : Fragment() {

    private val dataItem = DataInitItem()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataItem.setInitialSavedStateCat()
        dataItem.setInitialSavedStateNat()

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root:View = binding.root

        val recClickListenerCat = object: onRecyclerClickListener {
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("one","1")
                        startActivity(intent)
                    }
                    1 ->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("two","2")
                        startActivity(intent)
                    }
                    2->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("three","3")
                        startActivity(intent)
                    }
                    3->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("four","4")
                        startActivity(intent)
                    }
                    4->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("five","5")
                        startActivity(intent)
                    }
                    5->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("six","6")
                        startActivity(intent)
                    }
                    6->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("seven","7")
                        startActivity(intent)
                    }
                    7->{
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("eight","8")
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterCat = RecyclerAdapter(context, dataItem.dataItemCat, recClickListenerCat)
        binding.recyclerView.adapter = adapterCat

        val recClickListenerNat = object: onRecyclerClickListener {
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("nine","9")
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("ten","10")
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("eleven","11")
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("twelve","12")
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("thirteen","13")
                        startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        intent.putExtra("fourteen","14")
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterNat = RecyclerAdapter(context, dataItem.dataItemNat, recClickListenerNat)
        binding.recyclerView2.adapter = adapterNat
        return root
    }

}