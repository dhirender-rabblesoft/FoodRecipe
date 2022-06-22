package com.app.foodrecipe.adapter

 import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter

class CreateRecipeImageClickAdapter(val itemClick:(Int) ->Unit):BaseAdapter<String>(
    R.layout.item_recipe_img_click) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

}