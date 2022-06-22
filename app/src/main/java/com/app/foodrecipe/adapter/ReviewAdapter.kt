package com.app.foodrecipe.adapter

import androidx.constraintlayout.widget.ConstraintLayout
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.base.BaseAdapter
import kotlinx.android.synthetic.main.item_review.view.*


class ReviewAdapter(val type: Int, val itemClick: (Int) -> Unit) : BaseAdapter<String>(
    R.layout.item_review
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            when(type){
                Keys.FoodDetailReview->{
                    reviewcontainer.layoutParams.width = 800
                }
                Keys.Review -> {
                    reviewcontainer.layoutParams.width = ConstraintLayout.LayoutParams.MATCH_PARENT
                }
                Keys.TOP_CHEF_REVIEW -> {

                }
            }

        }

    }

    override fun getItemCount(): Int {
        return 10
    }

}