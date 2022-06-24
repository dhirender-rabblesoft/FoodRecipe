package com.app.foodrecipe.adapter

import com.app.foodrecipe.R
import com.app.foodrecipe.base.BaseAdapter
import com.app.foodrecipe.model.AddStepModel
import kotlinx.android.synthetic.main.item_add_recipe_steps.view.*

class ShowAddRecipeStepsAdapter(val itemClick: (Int) -> Unit) : BaseAdapter<AddStepModel>(
    R.layout.item_add_recipe_steps
) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {

        holder.itemView.apply {
            tvRecipeStepName.setText(list[position].stepTitle)
            tvRecipeStepDes.setText(list[position].stepDescription)
            fbCloseSideMenu.setOnClickListener {
                itemClick(position)
            }
        }

    }


}