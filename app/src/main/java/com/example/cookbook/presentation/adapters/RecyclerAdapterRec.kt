package com.example.cookbook.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.R
import com.example.cookbook.data.DataItemRec

class RecyclerAdapterRec internal constructor(context: Context?, dataItemRec: List<DataItemRec>, private val onClickListener: onRecyclerClickListenerRecipes):
      RecyclerView.Adapter<RecyclerAdapterRec.ViewHolder>(){

    private val inflater: LayoutInflater
    var dataItemRec:List<DataItemRec>

    init {
        this.dataItemRec = dataItemRec
        inflater = LayoutInflater.from(context)
    }

    class ViewHolder internal constructor(view: View):RecyclerView.ViewHolder(view){
        val tvName: TextView
        init {
            tvName = view.findViewById(R.id.tvName)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = inflater.inflate(R.layout.list_item_recipes,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: DataItemRec = dataItemRec[position]
        holder.tvName.setText(person.recipes)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(person,position)
        }
    }

    override fun getItemCount() = dataItemRec.size
}