package com.app.foodrecipe.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.foodrecipe.fragement.IngredientFragment
import com.app.foodrecipe.fragement.RecipeInstructionFragment
import com.app.foodrecipe.fragement.ReviewFragment

class PageAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position) {
           0 -> {
                RecipeInstructionFragment()
           }
           1 -> {
                IngredientFragment()
           }
           else-> {
                throw Resources.NotFoundException("Position Not Found")
           }
       }

    }
}