package com.example.cookbook.presentation.adapters

import com.example.cookbook.data.DataItemRec

interface onRecyclerClickListenerRecipes {
    fun onClick(dataRecipes: DataItemRec, position:Int)
}