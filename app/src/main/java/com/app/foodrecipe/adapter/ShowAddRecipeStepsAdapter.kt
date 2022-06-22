package com.app.foodrecipe.adapter

 import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter

class ShowAddRecipeStepsAdapter(val itemClick:(Int) ->Unit):BaseAdapter<String>(
    R.layout.item_add_recipe_steps) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

}