package com.app.foodrecipe.adapter

import android.util.Log
import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_recipe_img_click.view.*
import java.io.File

class CreateRecipeImageClickAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<File>(
    R.layout.item_recipe_img_click
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            Log.e("chdlistnow",list.toString())
            Glide.with(this).load(list[position]).diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).into(ivimageclick)
            fbCloseSideMenu.setOnClickListener {
                itemClick(position)
            }
        }

    }


}