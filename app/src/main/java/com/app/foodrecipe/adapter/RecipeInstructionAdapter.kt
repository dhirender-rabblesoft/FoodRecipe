package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter


class RecipeInstructionAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<String>(
    R.layout.item_recipe_step
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}