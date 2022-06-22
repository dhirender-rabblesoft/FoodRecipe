package com.app.foodrecipe.screens

import android.os.Bundle
import android.util.Log
import com.app.foodrecipe.R
import com.app.foodrecipe.Utils.Keys
import com.app.foodrecipe.base.KotlinBaseActivity
import com.app.foodrecipe.fragement.FoodRecipeDetails
import com.app.foodrecipe.fragement.MyTipsTrickListingFragment
import com.app.foodrecipe.fragement.ReviewFragment
import com.app.foodrecipe.fragement.TipsTrickDetailFragment

class CommonActivity : KotlinBaseActivity(R.id.container) {
    var getbundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        getbundle = intent.extras!!
        Log.e(
            "ewrewfsdfsdfdsf",
            getbundle.getString(Keys.FRAGMENT_FROM).toString().toInt().toString()
        )
        setFragment(getbundle.getString(Keys.FRAGMENT_FROM).toString().toInt())
    }

    private fun setFragment(type: Int) {
        when (type) {

            Keys.FRAGMENT_TODAY_POPULAR_RECIPE -> {
                navigateToFragment(FoodRecipeDetails(this), getbundle, false)
            }
            Keys.FRAGMENT_POUPAR_RECIPE -> {
                navigateToFragment(FoodRecipeDetails(this), getbundle, false)
            }
            Keys.FRAGMENT_NEW_RECIPE -> {
                navigateToFragment(FoodRecipeDetails(this), getbundle, false)
            }
//
//            Keys.FRAGMENT_MY_TIPS_TRICK_LISTING -> {
//                navigateToFragment(MyTipsTrickListingFragment(this), getbundle, false)
//            }
            Keys.FRAGMENT_MY_TIPS_TRICK_LISTING -> {
                navigateToFragment(TipsTrickDetailFragment(this), getbundle, false)
            }
            Keys.RECIPE_DETAIL_REVIEW -> {
                navigateToFragment(ReviewFragment(this), getbundle, false)
            }
        }


    }
}