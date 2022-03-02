package com.example.cookbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.cookbook.R
import com.example.cookbook.adapters.RecyclerAdapterRec
import com.example.cookbook.adapters.onRecyclerClickListenerRecipes
import com.example.cookbook.data.DataInitItem
import com.example.cookbook.data.DataItemRec
import com.example.cookbook.databinding.ActivityListRecipesBinding

class ListRecipes : AppCompatActivity() {

    lateinit var bindingListRecipes: ActivityListRecipesBinding
    private val dataItemRec = DataInitItem()
    private val spanHighlight by lazy {
        ForegroundColorSpan(ResourcesCompat.getColor(resources, R.color.red, null))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingListRecipes = ActivityListRecipesBinding.inflate(layoutInflater)
        setContentView(bindingListRecipes.root)
        dataItemRec.setInitialSavedStateRec()

        val recClickListenerRec = object: onRecyclerClickListenerRecipes {
            override fun onClick(dataRecipes: DataItemRec, position: Int) {
                when(position){
                    0 -> {
                        Toast.makeText(this@ListRecipes,"Test", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        val adapterCat = RecyclerAdapterRec(this, dataItemRec.dataItemRec, recClickListenerRec)
        bindingListRecipes.recyclerViewRecipes.adapter = adapterCat

        bindingListRecipes.research.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) { }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateSearch(adapterCat)
                highlight(adapterCat)
            }
        })


    }

    private fun updateSearch(adapterCat:RecyclerAdapterRec){
        val s = bindingListRecipes.research.text
        if (s?.length ==0){
            adapterCat.dataItemRec = dataItemRec.dataItemRec
        } else {
            adapterCat.dataItemRec = dataItemRec.dataItemRec.filter {
                it.recipes.startsWith(s.toString(),true)
            } as ArrayList
        }
        adapterCat.notifyDataSetChanged()
    }

    private fun highlight(adapterCat:RecyclerAdapterRec){
        val s = bindingListRecipes.research.text
        adapterCat.dataItemRec.forEach { item ->
            item.recipes.getSpans(0,item.recipes.length, ForegroundColorSpan::class.java).forEach {
                item.recipes.removeSpan(it)
            }
            if(item.recipes.contains(s!!,true)){
                val index = item.recipes.toString().indexOf(s.toString(),0,true)
                item.recipes.setSpan(spanHighlight,index,index + s.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }


}