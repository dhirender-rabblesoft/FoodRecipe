package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import kotlinx.android.synthetic.main.item_my_recipe.view.*

class MyRecipeAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<String>(
    R.layout.item_my_recipe
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            cvMyRecipeContainer.setOnClickListener {
                itemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

}