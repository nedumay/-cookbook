package com.example.cookbook.data

import android.text.Spannable
import android.text.SpannableString

data class DataItemRec (var recipes:Spannable) {
    constructor(recipes: String): this(SpannableString(recipes))
}