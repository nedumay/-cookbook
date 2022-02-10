package com.example.cookbook.data

import com.example.cookbook.R

class DataInitItem {


    internal val dataItemCat: ArrayList<DataItem> = ArrayList()
    internal val dataItemNat: ArrayList<DataItem> = ArrayList()

    fun setInitialSavedStateCat() {
        dataItemCat.add(DataItem(R.string.сold_appetizern, R.drawable.ice_appetizer))
        dataItemCat.add(DataItem(R.string.hot_appetizern, R.drawable.hot_appetizer))
        dataItemCat.add(DataItem(R.string.second_dishes, R.drawable.seconds_dishes))
        dataItemCat.add(DataItem(R.string.soup, R.drawable.soups))
        dataItemCat.add(DataItem(R.string.salads, R.drawable.salads))
        dataItemCat.add(DataItem(R.string.porridge, R.drawable.porridges))
        dataItemCat.add(DataItem(R.string.dessert, R.drawable.desserts))
        dataItemCat.add(DataItem(R.string.sauce, R.drawable.sauce))
        dataItemCat.add(DataItem(R.string.drinks, R.drawable.drinks))
    }

    fun setInitialSavedStateNat() {
        dataItemNat.add(DataItem(R.string.russian_kitchen, R.drawable.russia))
        dataItemNat.add(DataItem(R.string.asia_kitchen, R.drawable.asia))
        dataItemNat.add(DataItem(R.string.europe_kitchen, R.drawable.europe))
        dataItemNat.add(DataItem(R.string.kavkaz_kitchen, R.drawable.kavkaz))
        dataItemNat.add(DataItem(R.string.vostok_kitchen, R.drawable.vostok))
        dataItemNat.add(DataItem(R.string.mexico_kitchen, R.drawable.mexico))
    }
}