package com.example.cookbook.presentation.adapters

import com.example.cookbook.data.DataItem

interface onRecyclerClickListener {
    fun onClick(dataItem: DataItem, position:Int)
}

