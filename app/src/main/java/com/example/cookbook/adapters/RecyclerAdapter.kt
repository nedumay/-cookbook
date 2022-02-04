package com.example.cookbook.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbook.R
import com.example.cookbook.data.DataItem

class RecyclerAdapter internal constructor(context: Context?, dataItem: List<DataItem>, private val onClickListener:onRecyclerClickListener):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

        private val inflater: LayoutInflater
        private val dataItem:List<DataItem>


        init {
            this.dataItem = dataItem
            inflater = LayoutInflater.from(context)
        }

    class ViewHolder internal constructor(view: View):RecyclerView.ViewHolder(view) {
        val imgView: ImageView
        val textView: TextView
        init {
            imgView = view.findViewById(R.id.img_view)
            textView = view.findViewById(R.id.text_view)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = inflater.inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: DataItem = dataItem[position]
        holder.imgView.setImageResource(person.imgId)
        holder.textView.setText(person.titleId)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(person,position)
        }
    }

    override fun getItemCount(): Int {
        return dataItem.size
    }
}