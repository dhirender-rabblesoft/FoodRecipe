package com.app.foodrecipe.adapter

 import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
 import kotlinx.android.synthetic.main.item_filter_food_category.view.*
 import kotlinx.android.synthetic.main.item_popular.view.*

class CookingTimeFilterAdapter(val itemClick:(Int) ->Unit):BaseAdapter<String>(
    R.layout.item_filter_food_category) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            ivfoodtypeimg.setImageResource(R.drawable.ic_baseline_access_time_24)
            ivfoodtypetitle.setText("15 Min")
            cvPopularContainer.setOnClickListener {
                itemClick(position)
            }
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}