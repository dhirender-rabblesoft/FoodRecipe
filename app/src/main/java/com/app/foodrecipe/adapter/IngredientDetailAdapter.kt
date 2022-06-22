package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import kotlinx.android.synthetic.main.item_filter_food_category.view.*
import kotlinx.android.synthetic.main.item_popular.view.*

class IngredientDetailAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<String>(
    R.layout.item_ingredient
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}