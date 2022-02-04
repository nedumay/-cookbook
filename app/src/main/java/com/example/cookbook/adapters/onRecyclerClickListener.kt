package com.example.cookbook.adapters

import com.example.cookbook.data.DataItem

interface onRecyclerClickListener {
    fun onClick(dataItem: DataItem, position:Int)
}