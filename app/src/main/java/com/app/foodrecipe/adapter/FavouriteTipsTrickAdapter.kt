package com.app.foodrecipe.adapter

 import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
 import kotlinx.android.synthetic.main.item_popular.view.*

class FavouriteTipsTrickAdapter(val itemClick:(Int) ->Unit):BaseAdapter<String>(
    R.layout.item_tips_trick) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            cvConatiner.setOnClickListener {
                itemClick(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}