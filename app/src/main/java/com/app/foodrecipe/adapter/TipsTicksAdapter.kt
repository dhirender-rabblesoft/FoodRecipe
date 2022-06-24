package com.app.foodrecipe.adapter

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Utils
import com.app.foodrecipe.base.BaseAdapter
import com.app.foodrecipe.extension.prettyCount
import com.app.foodrecipe.model.TipsTrickModel
import kotlinx.android.synthetic.main.item_tips_trick.view.*

class TipsTicksAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<TipsTrickModel>(
    R.layout.item_tips_trick
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            tvfoodtitle.setText(list[position].title)
            tvmainIngradient.setText("Main Ingredient : " + list[position].mainIngredient)
            tvdescription.setText(list[position].description.toString())

            val countlike = prettyCount(list[position].likecount)
            tvlike.setText(countlike.toString())


            //favourite and unfavourite
            if (list[position].isLike) {
                ivfavouritIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                ivfavouritIcon.setImageResource(R.drawable.ic_baseline_favorite2)
            }
            ivfavouritIcon.setOnClickListener {
                if (list[position].isLike) {
                    list[position].isLike = false
                } else {
                    list[position].isLike = true
                }
                notifyDataSetChanged()
            }


            //share tips
            ivhshareIcon.setOnClickListener {
              Utils.shareintent(context,"This is data","MESSAGE")

            }
            cvConatiner.setOnClickListener {
                itemClick(position)
            }

        }

    }


}