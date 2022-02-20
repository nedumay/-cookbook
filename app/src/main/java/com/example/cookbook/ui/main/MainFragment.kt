package com.example.cookbook.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.R
import com.example.cookbook.adapters.RecyclerAdapter
import com.example.cookbook.adapters.onRecyclerClickListener
import com.example.cookbook.data.DataInitItem
import com.example.cookbook.data.DataItem
import com.example.cookbook.databinding.FragmentMainBinding
import com.example.cookbook.ui.ListRecipes

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
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterNat = RecyclerAdapter(context, dataItem.dataItemNat, recClickListenerNat)
        binding.recyclerView2.adapter = adapterNat
        return root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewCat: RecyclerView = view.findViewById(R.id.recyclerView)
        val recClickListenerCat = object: onRecyclerClickListener {
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterCat = RecyclerAdapter(context, dataItem.dataItemCat, recClickListenerCat)
        recyclerViewCat.adapter = adapterCat

        val recyclerViewNat: RecyclerView = view.findViewById(R.id.recyclerView2)
        val recClickListenerNat = object: onRecyclerClickListener {
            override fun onClick(dataItem: DataItem, position: Int) {
                when(position){
                    0 -> {
                        val intent = Intent(context, ListRecipes::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        val adapterNat = RecyclerAdapter(context, dataItem.dataItemNat, recClickListenerNat)
        recyclerViewNat.adapter = adapterNat
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/

}