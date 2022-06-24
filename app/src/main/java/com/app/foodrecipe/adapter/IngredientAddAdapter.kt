package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import com.app.foodrecipe.extension.isNotNull
import com.app.foodrecipe.model.AddIngredientModel
import kotlinx.android.synthetic.main.item_ingredient_add.view.*

class IngredientAddAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<AddIngredientModel>(
    R.layout.item_ingredient_add
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            tvIngredientName.setText(list[position].ingredient_name)
            tvingredientquantity.setText(list[position].ingredient_quantity)
            tvingredientUnit.setText(list[position].ingredient_unit)
            fbCloseSideMenu.setOnClickListener {
                itemClick(position)
            }

        }

    }


}