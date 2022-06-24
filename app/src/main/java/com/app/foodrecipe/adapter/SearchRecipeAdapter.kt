package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import com.app.foodrecipe.extension.prettyCount
import com.app.foodrecipe.model.AddFoodRecipe
import kotlinx.android.synthetic.main.item_search_bar.view.*


class SearchRecipeAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<AddFoodRecipe>(
    R.layout.item_search_bar
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            val countlike = prettyCount(list[position].likecount)
            foodtitle.setText(list[position].recipeName)
            tvfooddes.setText(list[position].recipeDes)
            tvlike.setText(countlike.toString())
            tvrating.setText(list[position].ratingCount.toString())
            tvrecpietime.setText(list[position].ratingCount.toString() + " Mins")
            cvConatiner.setOnClickListener {
                itemClick(position)
            }
        }


    }


}