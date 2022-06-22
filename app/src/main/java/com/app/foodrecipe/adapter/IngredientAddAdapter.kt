package com.app.foodrecipe.adapter

 import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter

class IngredientAddAdapter(val itemClick:(Int) ->Unit):BaseAdapter<String>(
    R.layout.item_ingredient_add) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

}